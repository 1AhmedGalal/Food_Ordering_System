package datahandlers.restrauntinterface;
import datahandlers.DataHandler;
import userinterfacecollectors.RestaurantInterface;

public abstract class RestaurantInterfaceDataHandler implements DataHandler
{
    RestaurantInterface restaurantInterface;

    RestaurantInterfaceDataHandler(RestaurantInterface restaurantInterface)
    {
        this.restaurantInterface = restaurantInterface;
    }
}
