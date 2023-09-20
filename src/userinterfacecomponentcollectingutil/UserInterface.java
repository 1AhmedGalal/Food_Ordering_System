package userinterfacecomponentcollectingutil;

import datahandlers.DataHandlerException;
import datahandlers.userinterfaceutil.UserInterfaceDataHandler;
import datahandlers.userinterfaceutil.UserInterfaceDummyDataHandler;
public class UserInterface extends UserInterfaceCollector
{
    public UserInterface() throws DataHandlerException {
        super();
        UserInterfaceDataHandler userInterfaceDataLoader = new UserInterfaceDummyDataHandler(this);
        userInterfaceDataLoader.loadAllData();
    }
}
