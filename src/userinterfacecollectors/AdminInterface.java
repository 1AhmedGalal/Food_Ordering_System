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
        AdminInterfaceDataHandlerFactory adminInterfaceDataHandlerFactory = new AdminInterfaceDataHandlerFactory();
        AdminInterfaceDataHandler adminInterfaceDataHandler = (AdminInterfaceDataHandler) adminInterfaceDataHandlerFactory.createDataHandler();
        adminInterfaceDataHandler.setObject(this);
        adminInterfaceDataHandler.loadAllData();
    }

}
