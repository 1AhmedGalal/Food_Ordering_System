package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.foods.FoodDataHandler;
import datahandlers.foods.FoodDataHandlerFactory;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import foods.Food;
import foods.MainDish;
import logger.Logger;
import menu.Menu;
import menu.RestaurantMenu;
import userinterfacecomponents.UserInterfaceComponent;
import users.Restaurant;

import java.util.Scanner;

public class RemoveMenuItemComponent extends UserInterfaceComponent
{
    public RemoveMenuItemComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Component number : ");
        int componentNumber = scanner.nextInt();

        Logger logger = Logger.getInstance();
        Restaurant restaurant = (Restaurant) logger.getUser();

        MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
        MenuDataHandler menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();
        menuDataHandler.loadAllData();

        Menu menu = new RestaurantMenu(restaurant.getPhone());
        menuDataHandler.setObject(menu);
        menu = (Menu) menuDataHandler.loadFullObject();

        String itemID = menu.getItemID(componentNumber);
        menu.RemoveItem(componentNumber);
        menuDataHandler.setObject(menu);
        menuDataHandler.updateObject();

        FoodDataHandlerFactory foodDataHandlerFactory = new FoodDataHandlerFactory();
        FoodDataHandler foodDataHandler = (FoodDataHandler) foodDataHandlerFactory.createDataHandler();
        foodDataHandler.loadAllData();
        Food food = new MainDish(itemID);
        foodDataHandler.setObject(food);
        foodDataHandler.removeObject();
    }
}
