package datahandlers.restrauntinterface;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;
import userinterfacecollectors.RestaurantInterface;

public class RestaurantInterfaceDataHandlerFactory implements DataHandlerFactory
{

    @Override
    public DataHandler createDataHandler()
    {
        return new RestaurantInterfaceDummyDataHandler();
    }
}
