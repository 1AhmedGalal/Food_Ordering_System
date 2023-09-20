package userinterfacecomponentutil.restaurantmenucomponentutil;

import dataloaders.DataLoader;
import dataloaders.orderutil.OrderDummyDataLoader;
import logger.Logger;
import orderutil.FoodOrderReceiver;
import orderutil.OrderReceiver;
import userinterfacecomponentutil.UserInterfaceComponent;
import users.User;

import java.util.ArrayList;

public class ViewOrdersComponent extends UserInterfaceComponent
{
    public ViewOrdersComponent(String message)
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