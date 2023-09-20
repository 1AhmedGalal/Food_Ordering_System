package logger;
import dataloaders.user.UserDataLoader;
import users.User;

public class Logger
{
    private static Logger instance = null;
    private User user;
    private Logger()
    {
        user = null;
    }

    public static Logger getInstance()
    {
        if(instance == null)
            instance = new Logger();

        return instance;
    }

    public void signIn(UserDataLoader dataLoader) throws LoggingException
    {
        dataLoader.loadAllData();

        if(userFound())
            throw new LoggingException("A user is already logged in");
        else if(!dataLoader.userExists())
            throw new LoggingException("User not found");

        this.user = (User) dataLoader.loadFullObject();
    }

    public void signUp(UserDataLoader dataLoader) throws LoggingException
    {
        dataLoader.loadAllData();

        if(userFound())
            throw new LoggingException("A user is already logged in");
        else if(dataLoader.userPhoneExists())
            throw new LoggingException("User already exists");

        dataLoader.saveObject(dataLoader.getUser());
        this.user = (User) dataLoader.loadFullObject();
    }

    public void signOut() throws LoggingException
    {
        if(!userFound())
            throw new LoggingException("No User Exists");

        user = null;
    }

    public User getUser()
    {
        return (this.user);
    }
    private boolean userFound()
    {
        return (this.user != null);
    }
}
