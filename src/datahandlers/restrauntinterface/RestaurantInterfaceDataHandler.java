package datahandlers.restrauntinterface;
import datahandlers.DataHandler;
import userinterfacecollectors.RestaurantInterface;

public abstract class RestaurantInterfaceDataHandler implements DataHandler
{
    RestaurantInterface restaurantInterface;

    RestaurantInterfaceDataHandler()
    {
        this.restaurantInterface = null;
    }

    @Override
    public void setObject(Object object)
    {
        this.restaurantInterface = (RestaurantInterface) object;
    }
}
