package logger;
import datahandlers.DataHandlerException;
import datahandlers.users.UserDataHandler;
import users.User;

public class Logger
{
    private static Logger instance = null;

    private User user;

    private static UserDataHandler userDataHandler;

    private Logger()
    {
        user = null;
        this.userDataHandler = null;
    }

    public static Logger getInstance(UserDataHandler userDataHandler) throws Exception
    {
        if(userDataHandler == null)
            throw new LoggingException("No Data Handler Found");

        if(instance == null)
            instance = new Logger();

        Logger.userDataHandler = userDataHandler;
        userDataHandler.loadAllData();

        return instance;
    }

    public void signIn() throws LoggingException, DataHandlerException {
        if(userLoggedIn())
            throw new LoggingException("A user is already logged in");
        else if(!userDataHandler.validUserData())
            throw new LoggingException("User not found");

        this.user = (User) userDataHandler.loadFullObject();
    }

    public void signUp() throws Exception
    {
        if(userLoggedIn())
            throw new LoggingException("A user is already logged in");
        else if(userDataHandler.userPhoneExists())
            throw new LoggingException("User already exists");

        userDataHandler.saveObject(userDataHandler.getUser());
        this.user = (User) userDataHandler.loadFullObject();
    }

    public void signOut() throws LoggingException
    {
        if(!userLoggedIn())
            throw new LoggingException("No User Exists");

        user = null;
    }

    public User getUser()
    {
        return this.user;
    }
    private boolean userLoggedIn()
    {
        return (this.user != null);
    }
}
