package userinterfacecomponentutil.restaurantmenucomponentutil;

import datasavingutil.DataLoader;
import datasavingutil.orderutil.OrderDummyDataLoader;
import loggingutil.Logger;
import menuutil.Menu;
import orderutil.FoodOrderReceiver;
import orderutil.OrderReceiver;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.NormalUser;
import usersutil.OnlineRestaurant;
import usersutil.Restaurant;
import usersutil.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewOrdersComponent extends UserInterfaceComponent
{
    public ViewOrdersComponent(String message)
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

        ArrayList<String> orders = orderReceiver.getUserOrders();

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
