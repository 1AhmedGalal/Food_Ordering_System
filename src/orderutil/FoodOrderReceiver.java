package orderutil;

import datahandlers.DataHandler;
import users.User;

public class FoodOrderReceiver extends OrderReceiver
{
    public FoodOrderReceiver(DataHandler dataHandler, User user)
    {
        super(dataHandler, user);
    }
}
