package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerException;
import datahandlers.usersdata.UserDataHandler;
import datahandlers.usersdata.UserDataHandlerFactory;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.OnsiteRestaurant;
import users.Restaurant;

import java.util.LinkedList;
import java.util.Scanner;

public class AddSiteComponent extends UserInterfaceComponent
{
    private Restaurant restaurant;
    public AddSiteComponent(String message)
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
            throw new Exception("This restaurant is not Onsite Restaurant");

        System.out.println("Enter Site : ");
        Scanner scanner = new Scanner(System.in);
        String site = scanner.next();

        addSite(site);
        updateSavedData();
    }

    private void addSite(String site) throws Exception
    {
        LinkedList<String> sites = ((OnsiteRestaurant) restaurant).getSites();

        if(sites != null && !sites.isEmpty())
        {
            for(String currentSite : sites)
            {
                if(currentSite.equals(site))
                    throw new Exception("Site already exists!");
            }
        }

        ((OnsiteRestaurant) restaurant).addSite(site);
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
