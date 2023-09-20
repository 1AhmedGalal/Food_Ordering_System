package datahandlers.restaurantinterfaceutil;
import datahandlers.DataHandler;
import userinterfacecollectors.RestaurantInterface;

public abstract class RestaurantInterfaceDataHandler implements DataHandler
{
    RestaurantInterface restaurantInterface;

    public RestaurantInterfaceDataHandler(RestaurantInterface restaurantInterface)
    {
        this.restaurantInterface = restaurantInterface;
    }
}
