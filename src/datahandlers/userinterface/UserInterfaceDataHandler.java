package datahandlers.userinterface;

import datahandlers.DataHandler;
import userinterfacecollectors.UserInterface;
import users.User;

public abstract class UserInterfaceDataHandler implements DataHandler
{
    UserInterface userInterface;

    UserInterfaceDataHandler()
    {
        this.userInterface = null;
    }

    @Override
    public void setObject(Object object)
    {
        this.userInterface = (UserInterface) object;
    }

}
