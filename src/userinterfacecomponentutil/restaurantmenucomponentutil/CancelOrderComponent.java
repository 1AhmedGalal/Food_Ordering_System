package userinterfacecomponentutil.restaurantmenucomponentutil;

import datasavingutil.DataLoader;
import datasavingutil.orderutil.OrderDummyDataLoader;
import loggingutil.Logger;
import orderutil.FoodOrderReceiver;
import orderutil.OrderReceiver;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.OnlineRestaurant;
import usersutil.Restaurant;
import usersutil.User;

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

        DataLoader dataLoader = new OrderDummyDataLoader(user); //needs fix
        OrderReceiver orderReceiver = new FoodOrderReceiver(dataLoader, user);

        System.out.println("Please Enter order ID : ");
        Scanner scanner = new Scanner(System.in);
        String orderId = scanner.next();

        orderReceiver.cancelOrder(orderId);
    }
}
