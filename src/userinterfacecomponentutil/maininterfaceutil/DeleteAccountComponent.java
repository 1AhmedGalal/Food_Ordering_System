package userinterfacecomponentutil.maininterfaceutil;

import dataloaders.user.UserDataDummyLoader;
import dataloaders.user.UserDataLoader;
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

        UserDataLoader userDataLoader = new UserDataDummyLoader(user);
        userDataLoader.removeObject(user);
    }
}
