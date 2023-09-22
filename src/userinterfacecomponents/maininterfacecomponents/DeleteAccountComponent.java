package userinterfacecomponents.maininterfacecomponents;

import datahandlers.DataHandlerFactory;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserDataHandlerFactory;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.User;

public class DeleteAccountComponent extends UserInterfaceComponent
{
    public DeleteAccountComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();

        Logger logger = Logger.getInstance();
        User user = logger.getUser();
        logger.signOut();

        userDataHandler.setObject(user);
        userDataHandler.loadAllData();
        userDataHandler.removeObject();
    }
}
