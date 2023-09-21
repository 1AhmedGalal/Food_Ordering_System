package datahandlers.admininterface;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;
import userinterfacecollectors.AdminInterface;

public class AdminInterfaceDataHandlerFactory implements DataHandlerFactory
{
    AdminInterface adminInterface;

    public AdminInterfaceDataHandlerFactory(AdminInterface adminInterface)
    {
        this.adminInterface = adminInterface;
    }


    @Override
    public DataHandler createDataHandler()
    {
        return new AdminInterfaceDummyDataHandler(adminInterface);
    }
}
