package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandler;
import datahandlers.orderutil.OrderDummyDataHandler;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.Restaurant;

import java.util.Scanner;

public class ConfirmOrderComponent extends UserInterfaceComponent
{
    public ConfirmOrderComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
//        Logger logger = Logger.getInstance();
//        Restaurant restaurant = (Restaurant) logger.getUser();
//
//        DataHandler dataHandler = new OrderDummyDataHandler(restaurant); //needs fix
//        OrderReceiver orderReceiver = new FoodOrderReceiver(dataHandler, restaurant);
//
//        System.out.println("Please Enter order ID : ");
//        Scanner scanner = new Scanner(System.in);
//        String orderId = scanner.next();
//
//        orderReceiver.confirmOrder(orderId);
    }
}
