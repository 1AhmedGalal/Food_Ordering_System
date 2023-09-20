package userinterfacecomponents.maininterfacecomponents;

import datahandlers.users.UserDataHandler;
import datahandlers.users.UserFileHandler;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;

public class SignOutComponent extends UserInterfaceComponent
{
    public SignOutComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        UserDataHandler userDataHandler = new UserFileHandler(null);
        Logger logger = Logger.getInstance(userDataHandler);
        logger.signOut();
    }
}
