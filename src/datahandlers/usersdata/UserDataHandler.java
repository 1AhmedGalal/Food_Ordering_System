package datahandlers.usersdata;
import datahandlers.DataHandler;
import users.User;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public abstract class UserDataHandler implements DataHandler
{
    protected boolean allDataLoaded;

    protected User user;

    protected UserType userType;

    protected Hashtable<String, User> users; // a lot of adding and removing is needed as well as fast lookups
    protected Hashtable<String, UserType> userTypes; // a lot of adding and removing is needed as well as fast lookups/

    UserDataHandler()
    {
        this.user = null;
        users = new Hashtable<>();
        userTypes = new Hashtable<>();
        allDataLoaded = false;
    }

    @Override
    public void setObject(Object object)
    {
        this.user = (User) object;
    }

    public abstract boolean userPhoneExists();
    public abstract boolean validUserData();
    public ArrayList<String> getAllUsersData(UserType userType)
    {
        ArrayList<String> usersData = new ArrayList<>();

        Set<String> setOfPhones = users.keySet();
        for(String phone : setOfPhones)
        {
            User user = users.get(phone);
            UserType currentUserType = userTypes.get(phone);

            if(currentUserType == userType)
            {
                String data = "Name : " + user.getName() + ", Phone : " + user.getPhone();
                usersData.add(data);
            }
        }

        return usersData;

    }

    @Override
    public void alertUpdate()
    {
        users.clear();
        userTypes.clear();
        allDataLoaded = false;
    }
}
