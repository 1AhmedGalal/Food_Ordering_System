package userinterfacecomponentcollectingutil;

import datasavingutil.admininterfaceutil.AdminInterfaceDataLoader;
import datasavingutil.admininterfaceutil.AdminInterfaceDummyDataLoader;
import datasavingutil.userinterfaceutil.UserInterfaceDataLoader;
import datasavingutil.userinterfaceutil.UserInterfaceDummyDataLoader;
public class UserInterface extends UserInterfaceCollector
{
    public UserInterface()
    {
        super();
        UserInterfaceDataLoader userInterfaceDataLoader = new UserInterfaceDummyDataLoader(this);
        userInterfaceDataLoader.loadAllData();
    }
}
