package datahandlers.userinterface;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;
import userinterfacecollectors.UserInterface;

public class UserInterfaceDataHandlerFactory implements DataHandlerFactory
{
    UserInterface userInterface;

    public UserInterfaceDataHandlerFactory(UserInterface userInterface)
    {
        this.userInterface = userInterface;
    }

    @Override
    public DataHandler createDataHandler()
    {
        return new UserInterfaceDummyDataHandler(userInterface);
    }
}
