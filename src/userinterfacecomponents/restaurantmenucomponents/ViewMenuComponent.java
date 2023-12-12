package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerFactory;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import datahandlers.usersdata.UserDataHandler;
import datahandlers.usersdata.UserDataHandlerFactory;
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
    private Menu menu;
    private Restaurant restaurant;
    public ViewMenuComponent(String message)
    {
        super(message);
        menu = null;
        restaurant = null;
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance();
        User user = logger.getUser();

        if(user instanceof Restaurant) //this is the restaurant displaying its own menu
            restaurant = (Restaurant) user;
        else                          //users wanting to see restaurants' menus
             makeRestaurant();

        makeMenu();
        ArrayList<String> menuItems = menu.getItemDetails();
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

    private void makeRestaurant() throws Exception
    {
        System.out.println("Please Enter Restaurant Phone : ");

        Scanner scanner = new Scanner(System.in);
        String phone = scanner.next();
        restaurant = new OnlineRestaurant(phone); //type doesn't matter as it will be corrected by the data handler

        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();

        userDataHandler.loadAllData();
        userDataHandler.setObject(restaurant);
        restaurant = (Restaurant) userDataHandler.loadFullObject();
    }

    private void makeMenu() throws Exception
    {
        MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
        MenuDataHandler menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();
        menuDataHandler.loadAllData();

        menu = new RestaurantMenu(restaurant.getPhone());
        menuDataHandler.setObject(menu);
        menu = (Menu) menuDataHandler.loadFullObject();
    }
}
