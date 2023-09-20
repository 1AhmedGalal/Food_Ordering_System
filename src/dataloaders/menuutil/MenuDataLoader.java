package dataloaders.menuutil;

import dataloaders.DataLoader;
import menuutil.Menu;
import menuutil.RestaurantMenu;
import users.Restaurant;

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
