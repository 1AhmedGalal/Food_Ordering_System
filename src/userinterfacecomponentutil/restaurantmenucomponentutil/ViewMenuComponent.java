package userinterfacecomponentutil.restaurantmenucomponentutil;

import datasavingutil.userutil.UserDataDummyLoader;
import datasavingutil.userutil.UserDataLoader;
import loggingutil.Logger;
import menuutil.Menu;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.OnlineRestaurant;
import usersutil.Restaurant;
import usersutil.User;

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
        Logger logger = Logger.getInstance();
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
            restaurant = (Restaurant) new OnlineRestaurant(name, null, null, null);
            UserDataLoader userDataLoader = new UserDataDummyLoader(restaurant);
            restaurant = (Restaurant) userDataLoader.loadFullObject();
        }

        Menu menu = restaurant.getMenu();

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
