package datahandlers.users;
import datahandlers.DataHandler;
import users.User;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class UserDataHandler implements DataHandler
{
    protected boolean allDataLoaded;

    protected User user;

    protected UserType userType;

    protected LinkedList<User> users; // a lot of adding and removing but no lookups

    protected LinkedList<UserType> userTypes; // a lot of adding and removing but no lookups

    public UserDataHandler(User user)
    {
        this.user = user;
        users = new LinkedList<>();
        userTypes = new LinkedList<>();
        allDataLoaded = false;
    }

    public abstract boolean userPhoneExists();
    public abstract boolean validUserData();

    public User getUser()
    {
        return user;
    }

    public ArrayList<String> getAllUsersData(UserType userType)
    {
        ArrayList<String> usersData = new ArrayList<>();

        for(int i = 0; i < users.size(); i++)
        {
            User user = users.get(i);
            UserType currentUserType = userTypes.get(i);

            if(currentUserType == userType)
            {
                String data = "Name : " + user.getName() + " Phone : " + user.getPhone();
                usersData.add(data);
            }
        }

        return usersData;

    }
}
