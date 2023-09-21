package datahandlers.users;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;
import users.User;

public class UserDataHandlerFactory implements DataHandlerFactory
{

    User user;

    public UserDataHandlerFactory()
    {
        this.user = null;
    }

    public UserDataHandlerFactory(User user)
    {
        this.user = user;
    }

    @Override
    public DataHandler createDataHandler()
    {
        return new UserFileHandler(user);
    }
}
