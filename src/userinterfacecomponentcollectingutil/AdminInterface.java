package userinterfacecomponentcollectingutil;

import dataloaders.admininterfaceutil.AdminInterfaceDataLoader;
import dataloaders.admininterfaceutil.AdminInterfaceDummyDataLoader;

public class AdminInterface extends UserInterfaceCollector
{
    public AdminInterface()
    {
        super();
        AdminInterfaceDataLoader adminInterfaceDataLoader = new AdminInterfaceDummyDataLoader(this);
        adminInterfaceDataLoader.loadAllData();
    }

}
