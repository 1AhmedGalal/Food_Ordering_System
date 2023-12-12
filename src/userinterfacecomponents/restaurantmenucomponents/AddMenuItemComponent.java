package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerException;
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
    private Restaurant restaurant;

    private String restaurantPhone;
    public AddMenuItemComponent(String message)
    {
        super(message);
        this.restaurant = null;
        this.restaurantPhone = null;
    }

    @Override
    public void doWork() throws Exception
    {
        loadRestaurantData();
        Scanner scanner = new Scanner(System.in);

        System.out.println("choose 1-add main dish\n2-add appetizer\n3-add drink");
        int choice = scanner.nextInt();

        if(choice < 1 || choice > 3)
            throw new Exception("Invalid Choice");

        String name = "";
        scanner.skip("\n");
        System.out.println("name : ");
        name = scanner.nextLine();

        String description = "";
        System.out.println("description : ");
        description += scanner.nextLine();

        String size;
        System.out.println("size : ");
        size = scanner.next();

        double price;
        System.out.println("price : ");
        price = scanner.nextDouble();

        Food food = null;
        switch (choice)
        {
            case 1:
                food = new MainDish(restaurantPhone, name, size, description, price);
                break;

            case 2:
                food = new Appetizer(restaurantPhone, name, size, description, price);
                break;

            case 3:
                String cupType;
                System.out.println("Cup Type : ");
                cupType = scanner.next();
                food = new Drink(restaurantPhone, name, size, description, price, cupType);
                break;
        }

        saveNewFoodData(food);
        updateMenu(food);
    }

    private void loadRestaurantData() throws Exception
    {
        Logger logger = Logger.getInstance();
        restaurant = (Restaurant) logger.getUser();
        restaurantPhone = restaurant.getPhone();
    }

    private void saveNewFoodData(Food food) throws Exception
    {
        FoodDataHandlerFactory foodDataHandlerFactory = new FoodDataHandlerFactory();
        FoodDataHandler foodDataHandler = (FoodDataHandler) foodDataHandlerFactory.createDataHandler();

        foodDataHandler.loadAllData();
        foodDataHandler.setObject(food);

        //if the loadFullObject() throws an exception that is fine
        //because this means that the food doesn't exist in the file
        try
        {
            foodDataHandler.loadFullObject();
        }
        catch (Exception e)
        {
            foodDataHandler.saveObject();
            return;
        }

        throw new Exception("Food Already Exists");
    }

    private void updateMenu(Food food) throws Exception
    {
        // 1) load all saved menu data
        MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
        MenuDataHandler menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();
        menuDataHandler.loadAllData();

        // 2) make a dummy menu then load the full one using the data handler
        Menu menu = new RestaurantMenu(restaurant.getPhone());
        menuDataHandler.setObject(menu);
        menu = (Menu) menuDataHandler.loadFullObject();

        // 3) add the new food item to the menu and update the menu in the saved data
        menu.addItem(food);
        menuDataHandler.setObject(menu);
        menuDataHandler.updateObject();
    }
}
