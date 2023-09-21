package datahandlers.admininterface;

import datahandlers.DataHandler;
import userinterfacecollectors.AdminInterface;

public abstract class AdminInterfaceDataHandler implements DataHandler
{
    AdminInterface adminInterface;

    AdminInterfaceDataHandler(AdminInterface adminInterface)
    {
        this.adminInterface = adminInterface;
    }
}
