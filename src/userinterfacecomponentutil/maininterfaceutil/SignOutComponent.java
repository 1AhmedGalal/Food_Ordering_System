package userinterfacecomponentutil.maininterfaceutil;

import logger.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;

public class SignOutComponent extends UserInterfaceComponent
{
    public SignOutComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance(null);
        logger.signOut();
    }
}
