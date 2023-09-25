package datahandlers.order;

import datahandlers.DataHandler;
import datahandlers.DataHandlerException;
import menu.Menu;
import orders.Order;
import users.User;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public abstract class OrderDataHandler implements DataHandler
{
    protected Order order;

    protected boolean allDataLoaded;

    protected Hashtable<String, LinkedList<String>> customerOrders; // key: customerID, value: orderIDs

    protected Hashtable<String, LinkedList<String>> providerOrders; // key: providerID, value: orderIDs

    protected Hashtable<String, Order> orders; // key: orderID, value: order
    OrderDataHandler()
    {
        this.order = null;
        this.allDataLoaded = false;
        this.providerOrders = new Hashtable<>();
        this.customerOrders = new Hashtable<>();
        this.orders = new Hashtable<>();
    }

    @Override
    public void setObject(Object object)
    {
        this.order = (Order) object;
    }

    @Override
    public void alertUpdate()
    {
        this.allDataLoaded = false;
    }

    public LinkedList<String> loadOrdersIDs(String userID) throws DataHandlerException
    {
        if(customerOrders.containsKey(userID))
        {
            return customerOrders.get(userID);
        }
        else if(providerOrders.containsKey(userID))
        {
            return providerOrders.get(userID);
        }
        else
        {
            throw new DataHandlerException("No Data Found");
        }
    }

    protected void addOrder(String ownerID, String orderID, Hashtable<String, LinkedList<String>> container)
    {
        //when the container is empty make it first
        if(!container.containsKey(ownerID) || container.get(ownerID).isEmpty())
            container.put(ownerID, new LinkedList<String>());

        container.get(ownerID).add(orderID);
    }

}