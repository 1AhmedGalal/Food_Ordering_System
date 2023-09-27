package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.usersdatahandler.UserDataHandler;
import datahandlers.usersdatahandler.UserDataHandlerFactory;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.OnlineRestaurant;
import users.OnsiteRestaurant;
import users.Restaurant;
import users.User;

import java.util.Scanner;

public class TransformRestaurantComponent extends UserInterfaceComponent
{
    public TransformRestaurantComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance();

        String currentType, newType;
        if(logger.getUser() instanceof OnsiteRestaurant)
        {
            currentType = "onsite";
            newType = "online";
        }
        else
        {
            currentType = "online";
            newType = "onsite";
        }

        System.out.println("Press 1 to make it " + newType + " restaurant instead of " + currentType + " and any other number to go back");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if(choice == 1)
        {
            User user = logger.getUser();
            Restaurant restaurant;

            if(currentType.equals("online"))
                restaurant = new OnsiteRestaurant((Restaurant) user);
            else
                restaurant = new OnlineRestaurant((Restaurant) user);

            UserDataHandlerFactory userDataHandlerFactory = new UserDataHandlerFactory();
            UserDataHandler userDataHandler = (UserDataHandler) userDataHandlerFactory.createDataHandler();

            userDataHandler.loadAllData();
            userDataHandler.setObject(restaurant);
            userDataHandler.updateObject();

            logger.signOut();
            logger.signIn(restaurant);
        }

    }
}
