package datahandlers.users;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;
import users.User;

public class UserDataHandlerFactory implements DataHandlerFactory
{
    @Override
    public DataHandler createDataHandler()
    {
        return new UserFileHandler();
    }
}
