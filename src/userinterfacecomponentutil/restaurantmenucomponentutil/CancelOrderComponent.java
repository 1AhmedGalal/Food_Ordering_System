package userinterfacecomponentutil.restaurantmenucomponentutil;

import dataloaders.DataLoader;
import dataloaders.orderutil.OrderDummyDataLoader;
import logger.Logger;
import orderutil.FoodOrderReceiver;
import orderutil.OrderReceiver;
import userinterfacecomponentutil.UserInterfaceComponent;
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
        Logger logger = Logger.getInstance(null);
        User user = logger.getUser();

        DataLoader dataLoader = new OrderDummyDataLoader(user); //needs fix
        OrderReceiver orderReceiver = new FoodOrderReceiver(dataLoader, user);

        System.out.println("Please Enter order ID : ");
        Scanner scanner = new Scanner(System.in);
        String orderId = scanner.next();

        orderReceiver.cancelOrder(orderId);
    }
}
