package datahandlers.maininterface;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;
import userinterfacecollectors.MainInterface;

public class UserInterfaceDataHandlerFactory implements DataHandlerFactory
{
    MainInterface mainInterface;

    public UserInterfaceDataHandlerFactory(MainInterface mainInterface)
    {
        this.mainInterface = mainInterface;
    }

    @Override
    public DataHandler createDataHandler()
    {
        return new MainInterfaceDummyDataHandler(mainInterface);
    }
}
