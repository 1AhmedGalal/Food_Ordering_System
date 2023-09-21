package datahandlers.maininterface;

import datahandlers.DataHandler;
import userinterfacecollectors.MainInterface;

public abstract class MainInterfaceDataHandler implements DataHandler
{
    MainInterface mainInterface;
    MainInterfaceDataHandler(MainInterface mainInterface)
    {
        this.mainInterface = mainInterface;
    }
}
