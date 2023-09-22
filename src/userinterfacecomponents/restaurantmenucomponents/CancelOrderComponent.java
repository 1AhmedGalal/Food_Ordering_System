package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandler;
import datahandlers.orderutil.OrderDummyDataHandler;
import logger.Logger;
import orderutil.FoodOrderReceiver;
import orderutil.OrderReceiver;
import userinterfacecomponents.UserInterfaceComponent;
import users.User;

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
        User user = logger.getUser();

        DataHandler dataHandler = new OrderDummyDataHandler(user); //needs fix
        OrderReceiver orderReceiver = new FoodOrderReceiver(dataHandler, user);

        System.out.println("Please Enter order ID : ");
        Scanner scanner = new Scanner(System.in);
        String orderId = scanner.next();

        orderReceiver.cancelOrder(orderId);
    }
}
