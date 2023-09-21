package datahandlers.restrauntinterface;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;
import userinterfacecollectors.RestaurantInterface;

public class RestaurantInterfaceDataHandlerFactory implements DataHandlerFactory
{
    RestaurantInterface restaurantInterface;

    public RestaurantInterfaceDataHandlerFactory(RestaurantInterface restaurantInterface)
    {
        this.restaurantInterface = restaurantInterface;
    }

    @Override
    public DataHandler createDataHandler()
    {
        return new RestaurantInterfaceDummyDataHandler(restaurantInterface);
    }
}
