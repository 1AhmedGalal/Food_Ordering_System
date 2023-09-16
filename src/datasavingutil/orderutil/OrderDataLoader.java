package datasavingutil.orderutil;

import datasavingutil.DataLoader;
import orderutil.Order;
import usersutil.User;

import java.security.PublicKey;
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
