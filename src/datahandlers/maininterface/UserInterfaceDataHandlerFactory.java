package datahandlers.maininterface;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;
import userinterfacecollectors.MainInterface;

public class UserInterfaceDataHandlerFactory implements DataHandlerFactory
{

    @Override
    public DataHandler createDataHandler()
    {
        return MainInterfaceDummyDataHandler.getInstance();
    }
}
