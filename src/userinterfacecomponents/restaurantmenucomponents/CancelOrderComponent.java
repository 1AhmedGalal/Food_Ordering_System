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
import users.User;

import java.util.Scanner;

public class CancelOrderComponent extends UserInterfaceComponent
{
    private User user;

    private Order order;

    private OrderDataHandler orderDataHandler;

    public CancelOrderComponent(String message)
    {
        super(message);
        this.user = null;
        this.order = null;
        this.orderDataHandler = null;
    }

    @Override
    public void doWork() throws Exception
    {
        generateUser();

        System.out.println("Please Enter order ID : ");
        Scanner scanner = new Scanner(System.in);
        String orderID = scanner.next();

        loadOrder(orderID);

        if(!canCancel())
            throw new Exception("Invalid operation");

        cancelOrder();
    }

    private void generateUser() throws Exception
    {
        Logger logger = Logger.getInstance();
        user = logger.getUser();
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

    private void cancelOrder() throws DataHandlerException
    {
        order.setOrderState(OrderState.CANCELED);
        orderDataHandler.setObject(order);
        orderDataHandler.updateObject();
    }

    private boolean canCancel()
    {
        //the "or" is because the one canceling the order can be the restaurant or the user
        return order.getOrderState() == OrderState.PROCESSING && (order.getProviderID().equals(user.getPhone())
                                                                  || order.getCostumerID().equals(user.getPhone()));
    }
}
