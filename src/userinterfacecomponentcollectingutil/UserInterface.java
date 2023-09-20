package userinterfacecomponentcollectingutil;

import dataloaders.userinterfaceutil.UserInterfaceDataLoader;
import dataloaders.userinterfaceutil.UserInterfaceDummyDataLoader;
public class UserInterface extends UserInterfaceCollector
{
    public UserInterface()
    {
        super();
        UserInterfaceDataLoader userInterfaceDataLoader = new UserInterfaceDummyDataLoader(this);
        userInterfaceDataLoader.loadAllData();
    }
}
