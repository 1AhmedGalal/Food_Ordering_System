package dataloaders.orderutil;

import dataloaders.DataLoader;
import orderutil.Order;
import users.User;

import java.util.ArrayList;

public abstract class OrderDataLoader implements DataLoader
{
    User user;

    ArrayList<Order> orders;
    public OrderDataLoader(User user)
    {
        this.user = user;
        orders = new ArrayList<>();
    }
}
