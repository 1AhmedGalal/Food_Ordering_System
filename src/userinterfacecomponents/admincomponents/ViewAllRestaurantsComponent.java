package userinterfacecomponents.admincomponents;

import datahandlers.DataHandlerFactory;
import datahandlers.usersdata.UserDataHandler;
import datahandlers.usersdata.UserDataHandlerFactory;
import datahandlers.usersdata.UserType;
import userinterfacecomponents.UserInterfaceComponent;

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
        // 1) get the data handler ready
        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();

        // 2) get onsite restaurants
        ArrayList<String> onsiteRestaurants = userDataHandler.getAllUsersData(UserType.ONSITE_RESTAURANT);
        for(String userData : onsiteRestaurants)
            System.out.println(userData);

        // 3) get online restaurants
        ArrayList<String> onlineRestaurants = userDataHandler.getAllUsersData(UserType.ONLINE_RESTAURANT);
        for(String userData : onlineRestaurants)
            System.out.println(userData);

    }
}
