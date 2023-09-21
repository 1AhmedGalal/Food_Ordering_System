package datahandlers.userinterface;

import datahandlers.DataHandler;
import userinterfacecollectors.UserInterface;

public abstract class UserInterfaceDataHandler implements DataHandler
{
    UserInterface userInterface;

    UserInterfaceDataHandler(UserInterface userInterface)
    {
        this.userInterface = userInterface;
    }
}
