package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.usersdatahandler.UserDataHandler;
import datahandlers.usersdatahandler.UserDataHandlerFactory;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.OnsiteRestaurant;

import java.util.LinkedList;
import java.util.Scanner;

public class RemoveSitesComponent extends UserInterfaceComponent
{
    public RemoveSitesComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance();

        if(!(logger.getUser() instanceof OnsiteRestaurant))
            throw new Exception("No Sites Available Since This Restaurant is not Onsite");

        OnsiteRestaurant restaurant = (OnsiteRestaurant) logger.getUser();

        LinkedList<String> sites = restaurant.getSites();
        if(sites.isEmpty())
            throw new Exception("No Sites Available");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Component number : ");
        int componentNumber = scanner.nextInt();
        restaurant.removeSite(componentNumber);

        UserDataHandlerFactory userDataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) userDataHandlerFactory.createDataHandler();
        userDataHandler.setObject(restaurant);
        userDataHandler.loadAllData();
        userDataHandler.updateObject();
    }
}
