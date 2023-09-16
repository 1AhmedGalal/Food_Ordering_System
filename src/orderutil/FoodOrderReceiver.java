package orderutil;

import datasavingutil.DataLoader;
import usersutil.User;

public class FoodOrderReceiver extends OrderReceiver
{
    public FoodOrderReceiver(DataLoader dataLoader, User user)
    {
        super(dataLoader, user);
    }
}
