package datahandlers.usersdata;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;

public class UserDataHandlerFactory implements DataHandlerFactory
{
    @Override
    public DataHandler createDataHandler()
    {
        return UserFileHandler.getInstance();
    }
}
