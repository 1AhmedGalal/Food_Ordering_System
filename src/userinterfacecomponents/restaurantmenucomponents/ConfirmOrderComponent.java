package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerException;
import datahandlers.order.OrderDataHandler;
import datahandlers.order.OrderDataHandlerFactory;
import logger.Logger;
import orders.FoodOrder;
import orders.Order;
import orders.OrderState;
import userinterfacecomponents.UserInterfaceComponent;
import users.Restaurant;

import java.util.Scanner;

public class ConfirmOrderComponent extends UserInterfaceComponent
{
    private Restaurant restaurant;

    private Order order;

    private OrderDataHandler orderDataHandler;

    public ConfirmOrderComponent(String message)
    {
        super(message);
        this.restaurant = null;
        this.order = null;
        this.orderDataHandler = null;
    }

    @Override
    public void doWork() throws Exception
    {
        generateRestaurant();

        System.out.println("Please Enter order ID : ");
        Scanner scanner = new Scanner(System.in);
        String orderID = scanner.next();

        loadOrder(orderID);

        if(!canConfirm())
            throw new Exception("Invalid operation");

        confirmOrder();
    }

    private void generateRestaurant() throws Exception
    {
        Logger logger = Logger.getInstance();
        restaurant = (Restaurant) logger.getUser();
    }

    private void loadOrder(String orderID) throws DataHandlerException
    {
        //load all orders
        OrderDataHandlerFactory orderDataHandlerFactory = new OrderDataHandlerFactory();
        orderDataHandler = (OrderDataHandler) orderDataHandlerFactory.createDataHandler();
        orderDataHandler.loadAllData();

        //load the order with given ID
        order = new FoodOrder(orderID); //type doesn't matter as it will be corrected with loadFullObject()
        orderDataHandler.setObject(order);
        order = (Order) orderDataHandler.loadFullObject();
    }

    private void confirmOrder() throws DataHandlerException
    {
        order.setOrderState(OrderState.DELIVERED);
        orderDataHandler.setObject(order);
        orderDataHandler.updateObject();
    }

    private boolean canConfirm()
    {
        return order.getOrderState() == OrderState.PROCESSING && (order.getProviderID().equals(restaurant.getPhone()));
    }
}
