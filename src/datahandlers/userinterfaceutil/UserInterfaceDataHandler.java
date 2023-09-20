package datahandlers.userinterfaceutil;

import datahandlers.DataHandler;
import userinterfacecomponentcollectingutil.UserInterface;

public abstract class UserInterfaceDataHandler implements DataHandler
{
    UserInterface userInterface;

    public UserInterfaceDataHandler(UserInterface userInterface)
    {
        this.userInterface = userInterface;
    }
}
