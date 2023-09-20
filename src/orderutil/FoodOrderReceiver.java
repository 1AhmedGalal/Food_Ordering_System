package orderutil;

import datahandlers.DataHandler;
import datahandlers.DataHandlerException;
import users.User;

public class FoodOrderReceiver extends OrderReceiver
{
    public FoodOrderReceiver(DataHandler dataHandler, User user) throws DataHandlerException {
        super(dataHandler, user);
    }
}
