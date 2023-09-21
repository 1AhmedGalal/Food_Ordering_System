package userinterfacecollectors;

import datahandlers.DataHandlerException;
import datahandlers.admininterface.AdminInterfaceDataHandler;
import datahandlers.admininterface.AdminInterfaceDataHandlerFactory;
import datahandlers.admininterface.AdminInterfaceDummyDataHandler;

public class AdminInterface extends UserInterfaceCollector
{
    public AdminInterface() throws DataHandlerException
    {
        super();
        AdminInterfaceDataHandlerFactory adminInterfaceDataHandlerFactory = new AdminInterfaceDataHandlerFactory(this);
        AdminInterfaceDataHandler adminInterfaceDataHandler = (AdminInterfaceDataHandler) adminInterfaceDataHandlerFactory.createDataHandler();
        adminInterfaceDataHandler.loadAllData();
    }

}
