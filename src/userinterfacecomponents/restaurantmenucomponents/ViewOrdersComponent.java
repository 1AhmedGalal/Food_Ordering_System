package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandler;
import datahandlers.DataHandlerException;
import datahandlers.order.OrderDataHandler;
import datahandlers.order.OrderDataHandlerFactory;
import logger.Logger;
import orders.FoodOrder;
import orders.Order;
import userinterfacecomponents.UserInterfaceComponent;
import users.User;

import java.util.LinkedList;

public class ViewOrdersComponent extends UserInterfaceComponent
{
    private User user;

    private OrderDataHandler orderDataHandler;

    public ViewOrdersComponent(String message)
    {
        super(message);
        this.user = null;
        this.orderDataHandler = null;
    }

    @Override
    public void doWork() throws Exception
    {
        getUser();
        loadDataHandler();

        LinkedList<String> orders = loadOrders();

        if(orders.isEmpty())
            throw new Exception("History is Empty");

        int id = 1;
        for(String orderID : orders)
        {
            Order order = new FoodOrder(orderID);
            orderDataHandler.setObject(order);
            order = (Order) orderDataHandler.loadFullObject();

            System.out.println(id + ") " + "Order ID:" + orderID + ", State : " + order.getOrderState() + ", Total Price : " + order.getTotalPrice());
            System.out.println("   " + "Restaurant Phone : " + order.getProviderID() + ", Customer Phone : " + order.getCostumerID());
            id++;

        }

        System.out.println("------------------------");
    }

    private void getUser() throws Exception
    {
        Logger logger = Logger.getInstance();
        user = logger.getUser();
    }

    private void loadDataHandler() throws DataHandlerException
    {
        OrderDataHandlerFactory orderDataHandlerFactory = new OrderDataHandlerFactory();
        orderDataHandler = (OrderDataHandler) orderDataHandlerFactory.createDataHandler();
        orderDataHandler.loadAllData();
    }

    private LinkedList<String> loadOrders() throws DataHandlerException
    {
        return orderDataHandler.loadOrdersIDs(user.getPhone());
    }
}
