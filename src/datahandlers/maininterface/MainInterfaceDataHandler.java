package datahandlers.maininterface;

import datahandlers.DataHandler;
import userinterfacecollectors.MainInterface;

public abstract class MainInterfaceDataHandler implements DataHandler
{
    MainInterface mainInterface;
    MainInterfaceDataHandler()
    {
        this.mainInterface = null;
    }

    @Override
    public void setObject(Object object)
    {
        this.mainInterface = (MainInterface) object;
    }
}
