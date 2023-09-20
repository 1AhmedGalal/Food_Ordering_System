package userinterfacecomponentutil.admincomponentsutil;

import datahandlers.users.UserDataDummyHandler;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserType;
import logger.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
import users.User;

import java.util.ArrayList;

public class ViewAllRestaurantsComponent extends UserInterfaceComponent
{
    public ViewAllRestaurantsComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance(null);
        User user = logger.getUser();

        UserDataHandler userDataHandler = new UserDataDummyHandler(user);
        userDataHandler.loadAllData();
        ArrayList<String> usersData = userDataHandler.getAllUsersData(UserType.ONSITE_RESTAURANT);

        for(String userData : usersData)
            System.out.println(userData);
    }
}
