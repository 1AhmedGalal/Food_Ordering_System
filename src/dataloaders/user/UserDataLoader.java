package dataloaders.user;
import dataloaders.DataLoader;
import users.NormalUser;
import users.Restaurant;
import users.User;
import java.util.ArrayList;

public abstract class UserDataLoader implements DataLoader
{
    protected boolean allDataLoaded;

    protected User user;
    protected UserType userType;

    protected ArrayList<User> users;

    protected ArrayList<UserType> userTypes;

    public UserDataLoader(User user)
    {
        this.user = user;
        users = new ArrayList<>();
        userTypes = new ArrayList<>();
        allDataLoaded = false;
    }

    public abstract boolean userPhoneExists();
    public abstract boolean userExists();

    public User getUser()
    {
        return user;
    }

    public ArrayList<String> getAllUsersData(UserType userType)
    {
        ArrayList<String> usersData = new ArrayList<>();

        String data;
        for(User user : users)
        {
            if(user instanceof NormalUser && userType == UserType.NORMAL)
            {
                data = "Name : " + user.getName() + " Phone : " + user.getPhone();
                usersData.add(data);
            }
            else if(user instanceof Restaurant && userType == UserType.RESTAURANT)
            {
                data = "Name : " + user.getName() + " Phone : " + user.getPhone();
                usersData.add(data);
            }


        }

        return usersData;

    }
}
