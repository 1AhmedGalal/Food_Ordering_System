package userinterfacecomponentutil.maininterfaceutil;

import datahandlers.users.UserDataDummyHandler;
import datahandlers.users.UserDataHandler;
import logger.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
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
        Logger logger = Logger.getInstance(null);
        User user = logger.getUser();
        logger.signOut();

        UserDataHandler userDataHandler = new UserDataDummyHandler(user);
        userDataHandler.removeObject(user);
    }
}
