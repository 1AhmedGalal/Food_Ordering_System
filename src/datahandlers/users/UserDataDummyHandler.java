package datahandlers.users;

import users.*;

public class UserDataDummyHandler extends UserDataHandler
{

    public UserDataDummyHandler(User user)
    {
        super(user);
    }

    @Override
    public boolean userPhoneExists()
    {
        for(User currentUser : users)
        {
            if(currentUser.getPhone().equals(this.user.getPhone()))
                return true;
        }

        return false;
    }

    @Override
    public boolean userExists()
    {
        for(User currentUser : users)
        {
            if(currentUser.getPhone().equals(this.user.getPhone()) && currentUser.getPassword().equals(this.user.getPassword()))
                return true;
        }

        return false;
    }

    @Override
    public void saveAllData()
    {
        if(!allDataLoaded)
            loadAllData();

        //clear file -> add the curr array of users
        users.add(this.user);
    }

    @Override
    public void loadAllData()
    {
//        allDataLoaded = true;
//
//        User tempUser = new NormalUser("ahmed", "123", "123");
//        users.add(tempUser);
//        userTypes.add(UserType.NORMAL);
//
//        tempUser = new OnlineRestaurant("beefy", "456", "456", null);
//        MenuDataLoader menuDataLoader = new MenuDummyDataLoader((Restaurant) tempUser);
//        menuDataLoader.loadAllData();
//        ((Restaurant) tempUser).setMenu((Menu)menuDataLoader.loadFullObject());
//        users.add(tempUser);
//        userTypes.add(UserType.RESTAURANT);
//
//        tempUser = new OnsiteRestaurant("beefy", "147", "147", null);
//        menuDataLoader = new MenuDummyDataLoader((Restaurant) tempUser);
//        menuDataLoader.loadAllData();
//        ((Restaurant) tempUser).setMenu((Menu)menuDataLoader.loadFullObject());
//        users.add(tempUser);
//        userTypes.add(UserType.RESTAURANT);
//
//        tempUser = new Admin("admin", "789", "789");
//        users.add(tempUser);
//        userTypes.add(UserType.ADMIN);

    }

    @Override
    public void saveObject(Object object)
    {
        User user = (User) object;
        UserType userType;

        if(user instanceof NormalUser)
            userType = UserType.NORMAL;
        else if(user instanceof Admin)
            userType = UserType.ADMIN;
        else
            userType = UserType.RESTAURANT;

        users.add(user);
        userTypes.add(userType);
    }

    @Override
    public void removeObject(Object object)
    {
        User user = (User) object;
        for(User user1 : users)
        {
            if(user1.getPhone().equals(user.getPhone()))
            {
                users.remove(user1);
                return;
            }
        }
    }

    @Override
    public Object loadFullObject()
    {
        User fullUser = null;

        for(User user : users)
        {
            if(user.getPhone().equals(this.user.getPhone()))
            {
                fullUser = user;

                int id = users.indexOf(user);
                this.userType = userTypes.get(id);

                break;
            }
        }

        return fullUser;
    }

}
