package userinterfacecomponentcollectingutil;

import datahandlers.admininterfaceutil.AdminInterfaceDataHandler;
import datahandlers.admininterfaceutil.AdminInterfaceDummyDataHandler;

public class AdminInterface extends UserInterfaceCollector
{
    public AdminInterface()
    {
        super();
        AdminInterfaceDataHandler adminInterfaceDataLoader = new AdminInterfaceDummyDataHandler(this);
        adminInterfaceDataLoader.loadAllData();
    }

}
