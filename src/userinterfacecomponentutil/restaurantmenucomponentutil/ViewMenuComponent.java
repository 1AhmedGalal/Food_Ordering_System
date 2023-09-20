package userinterfacecomponentutil.restaurantmenucomponentutil;

import dataloaders.user.UserDataDummyLoader;
import dataloaders.user.UserDataLoader;
import logger.Logger;
import menuutil.Menu;
import userinterfacecomponentutil.UserInterfaceComponent;
import users.OnlineRestaurant;
import users.Restaurant;
import users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewMenuComponent extends UserInterfaceComponent
{
    public ViewMenuComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance(null);
        User user = logger.getUser();
        Restaurant restaurant = null;

        if(user instanceof Restaurant)
        {
            restaurant = (Restaurant) user;
        }
        else
        {
            System.out.println("Please Enter Restaurant Name : ");

            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            restaurant = (Restaurant) new OnlineRestaurant(name, null, null);
            UserDataLoader userDataLoader = new UserDataDummyLoader(restaurant);
            restaurant = (Restaurant) userDataLoader.loadFullObject();
        }

        Menu menu = null; ///needs fix

        ArrayList<String> menuItems = menu.getItemsNames();

        if(menuItems.isEmpty())
            throw new Exception("Menu is Empty");

        int id = 1;
        for(String item : menuItems)
        {
            System.out.println(id + ") " + item);
            id++;
        }

        System.out.println("------------------------");


    }
}
