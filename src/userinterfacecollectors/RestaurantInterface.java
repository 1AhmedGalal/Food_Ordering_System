package userinterfacecollectors;

import datahandlers.DataHandlerException;
import datahandlers.restrauntinterface.RestaurantInterfaceDataHandler;
import datahandlers.restrauntinterface.RestaurantInterfaceDataHandlerFactory;
import datahandlers.restrauntinterface.RestaurantInterfaceDummyDataHandler;

public class RestaurantInterface extends UserInterfaceCollector
{
    public RestaurantInterface() throws DataHandlerException
    {
        super();
        RestaurantInterfaceDataHandlerFactory restaurantInterfaceDataHandlerFactory = new RestaurantInterfaceDataHandlerFactory();
        RestaurantInterfaceDataHandler restaurantInterfaceDataHandler = (RestaurantInterfaceDataHandler) restaurantInterfaceDataHandlerFactory.createDataHandler();
        restaurantInterfaceDataHandler.setObject(this);
        restaurantInterfaceDataHandler.loadAllData();
    }

}
