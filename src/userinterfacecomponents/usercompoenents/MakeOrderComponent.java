package userinterfacecomponents.usercompoenents;

import datahandlers.DataHandlerFactory;
import datahandlers.foods.FoodDataHandler;
import datahandlers.foods.FoodDataHandlerFactory;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import datahandlers.order.OrderDataHandler;
import datahandlers.order.OrderDataHandlerFactory;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserDataHandlerFactory;
import foods.Food;
import foods.MainDish;
import logger.Logger;
import menu.Menu;
import menu.RestaurantMenu;
import orders.FoodOrder;
import orders.Order;
import userinterfacecomponents.UserInterfaceComponent;
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
        Logger logger = Logger.getInstance();
        User user = logger.getUser();

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Please Enter Restaurant Phone : ");
        input = scanner.next();

        Restaurant restaurant = (Restaurant) new OnlineRestaurant(input);
        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();
        userDataHandler.setObject(restaurant);
        restaurant = (Restaurant) userDataHandler.loadFullObject();

        Menu menu = new RestaurantMenu(restaurant.getPhone()); ///nee

        MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
        MenuDataHandler menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();
        menuDataHandler.loadAllData();
        menuDataHandler.setObject(menu);
        menu = (Menu) menuDataHandler.loadFullObject();

        ArrayList<String> menuItems = menu.getItemsNames();
        for(String menuItem : menuItems)
            System.out.println(menuItem);

        double totalPrice = 0;
        ArrayList<String> foodIDs = new ArrayList<>();
        do
        {
            System.out.println("Enter Item number : ");
            int choice = scanner.nextInt();
            String foodID = menu.getItemID(choice);

            foodIDs.add(foodID);

            Food food = new MainDish(foodID);
            FoodDataHandlerFactory foodDataHandlerFactory = new FoodDataHandlerFactory();
            FoodDataHandler foodDataHandler = (FoodDataHandler) foodDataHandlerFactory.createDataHandler();
            foodDataHandler.loadAllData();;
            foodDataHandler.setObject(food);
            food = (Food) foodDataHandler.loadFullObject();
            totalPrice += food.getPrice();

            System.out.println("Would you like to continue adding food ? (y/n)");
            input = scanner.next();
        }
        while (input.charAt(0) == 'y');

        Order order = new FoodOrder(restaurant.getPhone(), user.getPhone(), foodIDs, totalPrice);
        OrderDataHandlerFactory orderDataHandlerFactory = new OrderDataHandlerFactory();
        OrderDataHandler orderDataHandler = (OrderDataHandler) orderDataHandlerFactory.createDataHandler();
        orderDataHandler.loadAllData();
        orderDataHandler.setObject(order);
        orderDataHandler.saveObject();
    }
}
