package datahandlers.menuutil;

import datahandlers.DataHandler;
import menu.Menu;
import menu.RestaurantMenu;
import users.Restaurant;

public abstract class MenuDataHandler implements DataHandler
{
    protected Restaurant restaurant;
    protected Menu menu;

    public MenuDataHandler(Restaurant restaurant)
    {
        this.restaurant = restaurant;
        //menu = new RestaurantMenu();
    }
}
