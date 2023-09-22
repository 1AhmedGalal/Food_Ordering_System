package logger;
import datahandlers.DataHandlerException;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserDataHandlerFactory;
import users.User;

public class Logger
{
    private static Logger instance = null;

    private User user;

    private static UserDataHandler userDataHandler;

    private static UserDataHandlerFactory userDataHandlerFactory;

    private Logger()
    {
        user = null;
        userDataHandlerFactory = new UserDataHandlerFactory();
        userDataHandler = (UserDataHandler) userDataHandlerFactory.createDataHandler();
    }

    public static Logger getInstance() throws Exception
    {
        if(instance == null)
            instance = new Logger();

        userDataHandler.loadAllData();

        return instance;
    }

    public void signIn(User user) throws LoggingException, DataHandlerException
    {
        userDataHandler.setObject(user);

        if(userLoggedIn())
            throw new LoggingException("A user is already logged in");
        else if(!userDataHandler.validUserData())
            throw new LoggingException("User not found");

        this.user = (User) userDataHandler.loadFullObject();
    }

    public void signUp(User user) throws Exception
    {
        userDataHandler.setObject(user);

        if(userLoggedIn())
            throw new LoggingException("A user is already logged in");
        else if(userDataHandler.userPhoneExists())
            throw new LoggingException("User already exists");

        userDataHandler.saveObject();
        this.user = (User) userDataHandler.loadFullObject();
    }

    public void signOut() throws Exception
    {
        if(!userLoggedIn())
            throw new LoggingException("No User Exists");

        userDataHandler.loadAllData(); //needed if a restaurant changes its type

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
