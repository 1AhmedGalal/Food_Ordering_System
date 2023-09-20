package datahandlers.maininterfaceutil;

import datahandlers.DataHandler;
import userinterfacecomponentcollectingutil.MainInterface;

public abstract class MainInterfaceDataHandler implements DataHandler
{
    MainInterface mainInterface;
    public MainInterfaceDataHandler(MainInterface mainInterface)
    {
        this.mainInterface = mainInterface;
    }
}