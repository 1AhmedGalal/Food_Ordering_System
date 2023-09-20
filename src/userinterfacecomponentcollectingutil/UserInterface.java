package userinterfacecomponentcollectingutil;

import datahandlers.userinterfaceutil.UserInterfaceDataHandler;
import datahandlers.userinterfaceutil.UserInterfaceDummyDataHandler;
public class UserInterface extends UserInterfaceCollector
{
    public UserInterface()
    {
        super();
        UserInterfaceDataHandler userInterfaceDataLoader = new UserInterfaceDummyDataHandler(this);
        userInterfaceDataLoader.loadAllData();
    }
}
