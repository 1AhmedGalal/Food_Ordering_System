package datahandlers.admininterface;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;
import userinterfacecollectors.AdminInterface;

public class AdminInterfaceDataHandlerFactory implements DataHandlerFactory
{
    @Override
    public DataHandler createDataHandler()
    {
        return AdminInterfaceDummyDataHandler.getInstance();
    }
}
