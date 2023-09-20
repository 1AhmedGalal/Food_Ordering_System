package datahandlers.admininterfaceutil;

import datahandlers.DataHandler;
import userinterfacecollectors.AdminInterface;

public abstract class AdminInterfaceDataHandler implements DataHandler
{
    AdminInterface adminInterface;

    public AdminInterfaceDataHandler(AdminInterface adminInterface)
    {
        this.adminInterface = adminInterface;
    }
}
