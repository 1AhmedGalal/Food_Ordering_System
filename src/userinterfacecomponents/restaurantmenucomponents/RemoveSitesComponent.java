package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerException;
import datahandlers.usersdatahandler.UserDataHandler;
import datahandlers.usersdatahandler.UserDataHandlerFactory;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.OnsiteRestaurant;
import users.Restaurant;
import users.UserException;

import java.util.LinkedList;
import java.util.Scanner;

public class RemoveSitesComponent extends UserInterfaceComponent
{
    private Restaurant restaurant;
    public RemoveSitesComponent(String message)
    {
        super(message);
        restaurant = null;
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance();
        restaurant = (Restaurant) logger.getUser();

        if(!(restaurant instanceof OnsiteRestaurant))
            throw new Exception("No Sites Available Since This Restaurant is not Onsite");

        LinkedList<String> sites = ((OnsiteRestaurant) restaurant).getSites();
        if(sites.isEmpty())
            throw new Exception("No Sites Available");

        System.out.println("Enter Component number : ");
        Scanner scanner = new Scanner(System.in);
        int componentNumber = scanner.nextInt();

        deleteSite(componentNumber, sites.size());
        updateSavedData();
    }

    private void deleteSite(int componentNumber, int sitesSize) throws Exception
    {
        if(componentNumber < 1 || componentNumber > sitesSize)
            throw new Exception("Invalid Choice");

        ((OnsiteRestaurant) restaurant).removeSite(componentNumber);
    }

    private void updateSavedData() throws DataHandlerException
    {
        UserDataHandlerFactory userDataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) userDataHandlerFactory.createDataHandler();

        userDataHandler.loadAllData();
        userDataHandler.setObject(restaurant);
        userDataHandler.updateObject();
    }
}
