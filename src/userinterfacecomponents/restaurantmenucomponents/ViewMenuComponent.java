package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerFactory;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import datahandlers.usersdatahandler.UserDataHandler;
import datahandlers.usersdatahandler.UserDataHandlerFactory;
import logger.Logger;
import menu.Menu;
import menu.RestaurantMenu;
import userinterfacecomponents.UserInterfaceComponent;
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
        Logger logger = Logger.getInstance();
        User user = logger.getUser();
        Restaurant restaurant = null;

        if(user instanceof Restaurant)
        {
            restaurant = (Restaurant) user;
        }
        else
        {
            System.out.println("Please Enter Restaurant Phone : ");

            Scanner scanner = new Scanner(System.in);
            String phone = scanner.next();
            restaurant = new OnlineRestaurant(phone);

            DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
            UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
            userDataHandler.loadAllData();

            userDataHandler.setObject(restaurant);
            restaurant = (Restaurant) userDataHandler.loadFullObject();
        }

        MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
        MenuDataHandler menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();
        menuDataHandler.loadAllData();

        Menu menu = new RestaurantMenu(restaurant.getPhone());
        menuDataHandler.setObject(menu);
        menu = (Menu) menuDataHandler.loadFullObject();

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
