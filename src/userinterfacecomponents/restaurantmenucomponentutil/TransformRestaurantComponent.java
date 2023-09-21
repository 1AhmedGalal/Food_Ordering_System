package userinterfacecomponents.restaurantmenucomponentutil;

import datahandlers.DataHandlerFactory;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserDataHandlerFactory;
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
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance(null);

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
        System.out.println();
        int choice = scanner.nextInt();

        if(choice == 1)
        {
            User user = logger.getUser();
            logger.signOut();

            DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory(user);
            UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
            userDataHandler.loadAllData();
            userDataHandler.removeObject(user);

            Restaurant restaurant;
            if(currentType.equals("online"))
                restaurant = new OnsiteRestaurant((Restaurant) user);
            else
                restaurant = new OnlineRestaurant((Restaurant) user);

            userDataHandler.saveObject(restaurant);
            logger.signIn();

        }

    }
}
