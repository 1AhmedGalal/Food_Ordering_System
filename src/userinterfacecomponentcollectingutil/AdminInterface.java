package userinterfacecomponentcollectingutil;

import datahandlers.DataHandlerException;
import datahandlers.admininterfaceutil.AdminInterfaceDataHandler;
import datahandlers.admininterfaceutil.AdminInterfaceDummyDataHandler;

public class AdminInterface extends UserInterfaceCollector
{
    public AdminInterface() throws DataHandlerException {
        super();
        AdminInterfaceDataHandler adminInterfaceDataLoader = new AdminInterfaceDummyDataHandler(this);
        adminInterfaceDataLoader.loadAllData();
    }

}
