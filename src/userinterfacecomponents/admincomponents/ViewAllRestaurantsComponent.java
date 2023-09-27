package userinterfacecomponents.admincomponents;

import datahandlers.DataHandlerFactory;
import datahandlers.usersdatahandler.UserDataHandler;
import datahandlers.usersdatahandler.UserDataHandlerFactory;
import datahandlers.usersdatahandler.UserType;
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
        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();

        ArrayList<String> onsiteRestaurants = userDataHandler.getAllUsersData(UserType.ONSITE_RESTAURANT);
        for(String userData : onsiteRestaurants)
            System.out.println(userData);

        ArrayList<String> onlineRestaurants = userDataHandler.getAllUsersData(UserType.ONLINE_RESTAURANT);
        for(String userData : onlineRestaurants)
            System.out.println(userData);

    }
}
