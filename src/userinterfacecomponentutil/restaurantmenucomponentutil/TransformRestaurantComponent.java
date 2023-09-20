package userinterfacecomponentutil.restaurantmenucomponentutil;

import dataloaders.user.UserDataDummyLoader;
import dataloaders.user.UserDataLoader;
import logger.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
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

            UserDataLoader dataLoader = new UserDataDummyLoader(user);
            dataLoader.loadAllData();
            dataLoader.removeObject(user);

            Restaurant restaurant;
            if(currentType.equals("online"))
                restaurant = new OnsiteRestaurant((Restaurant) user);
            else
                restaurant = new OnlineRestaurant((Restaurant) user);

            dataLoader.saveObject(restaurant);
            logger.signIn(dataLoader);

        }

    }
}