package orderutil;

import dataloaders.DataLoader;
import users.User;

public class FoodOrderReceiver extends OrderReceiver
{
    public FoodOrderReceiver(DataLoader dataLoader, User user)
    {
        super(dataLoader, user);
    }
}
