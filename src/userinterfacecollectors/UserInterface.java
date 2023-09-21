package userinterfacecollectors;

import datahandlers.DataHandlerException;
import datahandlers.userinterface.UserInterfaceDataHandler;
import datahandlers.userinterface.UserInterfaceDataHandlerFactory;
import datahandlers.userinterface.UserInterfaceDummyDataHandler;
public class UserInterface extends UserInterfaceCollector
{
    public UserInterface() throws DataHandlerException
    {
        super();
        UserInterfaceDataHandlerFactory userInterfaceDataHandlerFactory = new UserInterfaceDataHandlerFactory(this);
        UserInterfaceDataHandler userInterfaceDataLoader = (UserInterfaceDataHandler) userInterfaceDataHandlerFactory.createDataHandler();
        userInterfaceDataLoader.loadAllData();
    }
}
