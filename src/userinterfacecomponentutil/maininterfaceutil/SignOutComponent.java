package userinterfacecomponentutil.maininterfaceutil;

import loggingutil.Logger;
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
        Logger logger = Logger.getInstance();
        logger.signOut();
    }
}
