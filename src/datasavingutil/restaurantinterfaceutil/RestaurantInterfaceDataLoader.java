package datasavingutil.restaurantinterfaceutil;

import datasavingutil.DataLoader;
import userinterfacecomponentcollectingutil.RestaurantInterface;

public abstract class RestaurantInterfaceDataLoader implements DataLoader
{
    RestaurantInterface restaurantInterface;

    public RestaurantInterfaceDataLoader(RestaurantInterface restaurantInterface)
    {
        this.restaurantInterface = restaurantInterface;
    }
}
