package userinterfacecomponentutil.usercompoenentsutil;

import datasavingutil.DataLoader;
import datasavingutil.orderutil.OrderDummyDataLoader;
import datasavingutil.userutil.UserDataDummyLoader;
import datasavingutil.userutil.UserDataLoader;
import foodutil.Food;
import loggingutil.Logger;
import menuutil.Menu;
import orderutil.FoodOrder;
import orderutil.FoodOrderReceiver;
import orderutil.Order;
import orderutil.OrderReceiver;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.OnlineRestaurant;
import usersutil.Restaurant;
import usersutil.User;

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
        Logger logger = Logger.getInstance();
        User user = logger.getUser();

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Please Enter Restaurant Name : ");
        input = scanner.next();

        Restaurant restaurant = (Restaurant) new OnlineRestaurant(input, null, null, null);
        UserDataLoader userDataLoader = new UserDataDummyLoader(restaurant);
        restaurant = (Restaurant) userDataLoader.loadFullObject();

        Menu menu = restaurant.getMenu();
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
