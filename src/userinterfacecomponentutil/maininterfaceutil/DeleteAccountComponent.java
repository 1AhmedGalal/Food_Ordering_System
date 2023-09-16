package userinterfacecomponentutil.maininterfaceutil;

import datasavingutil.userutil.UserDataDummyLoader;
import datasavingutil.userutil.UserDataLoader;
import loggingutil.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.User;

public class DeleteAccountComponent extends UserInterfaceComponent
{
    public DeleteAccountComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance();
        User user = logger.getUser();
        logger.signOut();

        UserDataLoader userDataLoader = new UserDataDummyLoader(user);
        userDataLoader.removeObject(user);
    }
}
