package userinterfacecomponentutil.restaurantmenucomponentutil;

import dataloaders.DataLoader;
import dataloaders.orderutil.OrderDummyDataLoader;
import logger.Logger;
import orderutil.FoodOrderReceiver;
import orderutil.OrderReceiver;
import userinterfacecomponentutil.UserInterfaceComponent;
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
        Logger logger = Logger.getInstance();
        Restaurant restaurant = (Restaurant) logger.getUser();

        DataLoader dataLoader = new OrderDummyDataLoader(restaurant); //needs fix
        OrderReceiver orderReceiver = new FoodOrderReceiver(dataLoader, restaurant);

        System.out.println("Please Enter order ID : ");
        Scanner scanner = new Scanner(System.in);
        String orderId = scanner.next();

        orderReceiver.confirmOrder(orderId);
    }
}
