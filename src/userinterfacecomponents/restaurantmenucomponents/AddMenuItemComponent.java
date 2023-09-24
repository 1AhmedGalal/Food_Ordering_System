package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.foods.FoodDataHandler;
import datahandlers.foods.FoodDataHandlerFactory;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import foods.Appetizer;
import foods.Drink;
import foods.Food;
import foods.MainDish;
import logger.Logger;
import menu.Menu;
import menu.RestaurantMenu;
import userinterfacecomponents.UserInterfaceComponent;
import users.Restaurant;

import java.util.Scanner;

public class AddMenuItemComponent extends UserInterfaceComponent
{
    public AddMenuItemComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance();
        Restaurant restaurant = (Restaurant) logger.getUser();
        String phone = restaurant.getPhone();

        Scanner scanner = new Scanner(System.in);

        System.out.println("choose 1-add main dish\n2-add appetizer\n3-add drink");
        int choice = scanner.nextInt();

        if(choice < 1 || choice > 3)
            throw new Exception("Invalid Choice");

        String name;
        System.out.println("name : ");
        name = scanner.next();

        String description;
        System.out.println("description : ");
        description = scanner.next();

        String size;
        System.out.println("size : ");
        size = scanner.next();

        double price;
        System.out.println("price : ");
        price = scanner.nextDouble();;

        Food food = null;
        switch (choice)
        {
            case 1:
                food = new MainDish(phone, name, size, description, price);
                break;

            case 2:
                food = new Appetizer(phone, name, size, description, price);
                break;

            case 3:
                String cupType;
                System.out.println("Cup Type : ");
                cupType = scanner.next();
                food = new Drink(phone, name, size, description, price, cupType);
                break;
        }


        FoodDataHandlerFactory foodDataHandlerFactory = new FoodDataHandlerFactory();
        FoodDataHandler foodDataHandler = (FoodDataHandler) foodDataHandlerFactory.createDataHandler();
        foodDataHandler.loadAllData();
        foodDataHandler.setObject(food);
        foodDataHandler.saveObject();

        MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
        MenuDataHandler menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();
        menuDataHandler.loadAllData();

        Menu menu = new RestaurantMenu(restaurant.getPhone());
        menuDataHandler.setObject(menu);
        menu = (Menu) menuDataHandler.loadFullObject();

        menu.addItem(food);

        menuDataHandler.setObject(menu);
        menuDataHandler.updateObject();

    }
}
