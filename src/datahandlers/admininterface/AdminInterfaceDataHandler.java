package datahandlers.admininterface;

import datahandlers.DataHandler;
import userinterfacecollectors.AdminInterface;

public abstract class AdminInterfaceDataHandler implements DataHandler
{
    AdminInterface adminInterface;

    AdminInterfaceDataHandler()
    {
        this.adminInterface = null;
    }

    @Override
    public void setObject(Object object) {
        this.adminInterface = (AdminInterface) object;
    }

}
