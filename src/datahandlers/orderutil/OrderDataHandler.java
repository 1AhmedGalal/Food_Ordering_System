package datahandlers.orderutil;

import datahandlers.DataHandler;
import orders.Order;
import users.User;

import java.util.ArrayList;

public abstract class OrderDataHandler implements DataHandler
{
    User user;

    ArrayList<Order> orders;
    public OrderDataHandler(User user)
    {
        this.user = user;
        orders = new ArrayList<>();
    }
}
