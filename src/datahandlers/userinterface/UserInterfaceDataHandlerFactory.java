package datahandlers.userinterface;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;
import userinterfacecollectors.UserInterface;

public class UserInterfaceDataHandlerFactory implements DataHandlerFactory
{

    @Override
    public DataHandler createDataHandler()
    {
        return UserInterfaceDummyDataHandler.getInstance();
    }
}
