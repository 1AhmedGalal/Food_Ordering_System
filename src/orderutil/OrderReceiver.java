package orderutil;

import datahandlers.DataHandler;
import users.User;

import java.util.ArrayList;

public abstract class OrderReceiver
{
    protected User user;
    protected ArrayList<Order> orders;
    protected DataHandler dataHandler;

    public OrderReceiver(DataHandler dataHandler, User user)
    {
        orders = new ArrayList<>();
        this.user = user;
        this.dataHandler = dataHandler;

        dataHandler.loadAllData();
        orders = (ArrayList<Order>) dataHandler.loadFullObject();
    }

    public void addOrder(Order order)
    {
        orders.add(order);
        dataHandler.saveAllData();
    }

    public ArrayList<String> getUserOrders()
    {
        ArrayList<String> userOrders = new ArrayList<>();

        for(Order order : orders)
        {
            if(order.getCostumer().equals(user) || order.getProvider().equals(user))
                userOrders.add(order.toString());
        }

        return userOrders;
    }

    public void cancelOrder(String id) throws Exception
    {
        for(Order order : orders)
        {
            if(order.getId().equals(id))
            {
                if(order.getOrderState() == OrderState.DELIVERED)
                    throw new Exception("Invalid Operation");

                order.setOrderState(OrderState.CANCELED);
            }
        }
    }

    public void confirmOrder(String id) throws Exception
    {
        for(Order order : orders)
        {
            if(order.getId().equals(id))
            {
                if(order.getOrderState() == OrderState.CANCELED)
                    throw new Exception("Invalid Operation");

                order.setOrderState(OrderState.DELIVERED);
            }
        }
    }

    public void AddOrder(Order order)
    {
        orders.add(order);
    }




}
