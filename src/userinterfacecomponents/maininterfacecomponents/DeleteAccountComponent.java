package userinterfacecomponents.maininterfacecomponents;

import datahandlers.users.UserDataDummyHandler;
import datahandlers.users.UserDataHandler;
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
        UserDataHandler userDataHandler = new UserDataDummyHandler(null);

        Logger logger = Logger.getInstance(userDataHandler);
        User user = logger.getUser();
        logger.signOut();

        userDataHandler.loadAllData();
        userDataHandler.removeObject(user);
    }
}
