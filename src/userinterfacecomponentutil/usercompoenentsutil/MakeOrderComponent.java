package userinterfacecomponentutil.usercompoenentsutil;

import dataloaders.DataLoader;
import dataloaders.orderutil.OrderDummyDataLoader;
import dataloaders.user.UserDataDummyLoader;
import dataloaders.user.UserDataLoader;
import foodutil.Food;
import logger.Logger;
import menuutil.Menu;
import orderutil.FoodOrder;
import orderutil.FoodOrderReceiver;
import orderutil.Order;
import orderutil.OrderReceiver;
import userinterfacecomponentutil.UserInterfaceComponent;
import users.OnlineRestaurant;
import users.Restaurant;
import users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class MakeOrderComponent extends UserInterfaceComponent
{
    public MakeOrderComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance(null);
        User user = logger.getUser();

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Please Enter Restaurant Name : ");
        input = scanner.next();

        Restaurant restaurant = (Restaurant) new OnlineRestaurant(input, null ,null);
        UserDataLoader userDataLoader = new UserDataDummyLoader(restaurant);
        restaurant = (Restaurant) userDataLoader.loadFullObject();

        Menu menu = null; ///needs fix
        ArrayList<String> menuItems = menu.getItemsNames();
        for(String menuItem : menuItems)
            System.out.println(menuItem);

        ArrayList<Food> foods = new ArrayList<>();
        do
        {
            System.out.println("Enter Item number : ");
            int choice = scanner.nextInt();
            foods.add(menu.getItem(choice));

            System.out.println("Would you like to continue adding food ? (y/n)");
            input = scanner.next();

        }
        while (input.charAt(0) == 'y');

        String id = user.getPhone()+restaurant.getPhone();
        Order order = new FoodOrder(user, restaurant, foods, id);

        DataLoader dataLoader = new OrderDummyDataLoader(user);
        OrderReceiver orderReceiver = new FoodOrderReceiver(dataLoader, user);
        orderReceiver.AddOrder(order);
    }
}
