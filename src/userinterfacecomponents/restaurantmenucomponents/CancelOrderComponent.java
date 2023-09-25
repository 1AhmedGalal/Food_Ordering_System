package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.order.OrderDataHandler;
import datahandlers.order.OrderDataHandlerFactory;
import logger.Logger;
import orders.FoodOrder;
import orders.Order;
import orders.OrderState;
import userinterfacecomponents.UserInterfaceComponent;
import users.Restaurant;

import java.util.Scanner;

public class CancelOrderComponent extends UserInterfaceComponent
{
    public CancelOrderComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance();
        Restaurant restaurant = (Restaurant) logger.getUser();

        OrderDataHandlerFactory orderDataHandlerFactory = new OrderDataHandlerFactory();
        OrderDataHandler orderDataHandler = (OrderDataHandler) orderDataHandlerFactory.createDataHandler();
        orderDataHandler.loadAllData();

        System.out.println("Please Enter order ID : ");
        Scanner scanner = new Scanner(System.in);
        String orderId = scanner.next();

        Order order = new FoodOrder(orderId);
        orderDataHandler.setObject(order);
        order = (Order) orderDataHandler.loadFullObject();

        if(order.getOrderState() != OrderState.PROCESSING || !order.getProviderID().equals(restaurant.getPhone()))
            throw new Exception("Invalid operation");

        order.setOrderState(OrderState.CANCELED);
        orderDataHandler.setObject(order);
        orderDataHandler.updateObject();
    }
}
