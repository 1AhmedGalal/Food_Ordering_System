package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.users.UserDataHandler;
import datahandlers.users.UserDataHandlerFactory;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.OnsiteRestaurant;

import java.util.LinkedList;
import java.util.Scanner;

public class AddSiteComponent extends UserInterfaceComponent
{
    public AddSiteComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
       Logger logger = Logger.getInstance();

        if(!(logger.getUser() instanceof OnsiteRestaurant))
            throw  new Exception("This restaurant is not Onsite Restaurant");

        OnsiteRestaurant restaurant = (OnsiteRestaurant) logger.getUser();
        LinkedList<String> sites = restaurant.getSites();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Site : ");
        String site = scanner.next();

        restaurant.addSite(site);

        UserDataHandlerFactory userDataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) userDataHandlerFactory.createDataHandler();
        userDataHandler.setObject(restaurant);
        userDataHandler.loadAllData();
        userDataHandler.updateObject();

    }
}
