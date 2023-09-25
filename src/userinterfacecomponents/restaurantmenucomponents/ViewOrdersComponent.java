package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandler;
import datahandlers.order.OrderDataHandler;
import datahandlers.order.OrderDataHandlerFactory;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.User;

import java.util.LinkedList;

public class ViewOrdersComponent extends UserInterfaceComponent {
    public ViewOrdersComponent(String message) {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance();
        User user = logger.getUser();

        OrderDataHandlerFactory orderDataHandlerFactory = new OrderDataHandlerFactory();
        OrderDataHandler orderDataHandler = (OrderDataHandler) orderDataHandlerFactory.createDataHandler();
        orderDataHandler.loadAllData();

        LinkedList<String> orders = orderDataHandler.loadOrdersIDs(user.getPhone());

        if(orders.isEmpty())
            throw new Exception("History is Empty");

        int id = 1;
        for(String order : orders)
        {
            System.out.println(id + ") " + order);
            id++;
        }

        System.out.println("------------------------");
    }

}
