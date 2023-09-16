package orderutil;

import datasavingutil.DataLoader;
import usersutil.User;

import java.util.ArrayList;

public abstract class OrderReceiver
{
    protected User user;
    protected ArrayList<Order> orders;
    protected DataLoader dataLoader;

    public OrderReceiver(DataLoader dataLoader, User user)
    {
        orders = new ArrayList<>();
        this.user = user;
        this.dataLoader = dataLoader;

        dataLoader.loadAllData();
        orders = (ArrayList<Order>) dataLoader.loadFullObject();
    }

    public void addOrder(Order order)
    {
        orders.add(order);
        dataLoader.saveAllData();
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
