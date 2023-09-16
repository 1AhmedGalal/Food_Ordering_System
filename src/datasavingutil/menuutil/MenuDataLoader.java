package datasavingutil.menuutil;

import datasavingutil.DataLoader;
import menuutil.Menu;
import menuutil.RestaurantMenu;
import usersutil.Restaurant;

public abstract class MenuDataLoader implements DataLoader
{
    protected Restaurant restaurant;
    protected Menu menu;

    public MenuDataLoader(Restaurant restaurant)
    {
        this.restaurant = restaurant;
        menu = new RestaurantMenu();
    }
}
