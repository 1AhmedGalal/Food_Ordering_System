package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerException;
import datahandlers.foods.FoodDataHandler;
import datahandlers.foods.FoodDataHandlerFactory;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import foods.Food;
import foods.MainDish;
import logger.Logger;
import menu.Menu;
import menu.MenuException;
import menu.RestaurantMenu;
import userinterfacecomponents.UserInterfaceComponent;
import users.Restaurant;

import java.util.Scanner;

public class RemoveMenuItemComponent extends UserInterfaceComponent
{
    private Restaurant restaurant;
    private Menu menu;
    private String removedItemID;

    private FoodDataHandler foodDataHandler;

    private MenuDataHandler menuDataHandler;

    public RemoveMenuItemComponent(String message)
    {
        super(message);
        restaurant = null;
        menu = null;
        removedItemID = null;
        foodDataHandler = null;
        menuDataHandler = null;
    }

    @Override
    public void doWork() throws Exception
    {
        generateDataHandlers();

        Logger logger = Logger.getInstance();
        restaurant = (Restaurant) logger.getUser();

        //display the menu for the user
        ViewMenuComponent viewMenuComponent = new ViewMenuComponent("display menu");
        viewMenuComponent.doWork();

        System.out.println("Enter Component number : ");
        Scanner scanner = new Scanner(System.in);
        int componentNumber = scanner.nextInt();

        loadMenu();
        removeMenuItem(componentNumber);
        updateMenuData();
        updateFoodData();
    }

    private void generateDataHandlers() throws DataHandlerException
    {
        MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
        menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();
        menuDataHandler.loadAllData();

        FoodDataHandlerFactory foodDataHandlerFactory = new FoodDataHandlerFactory();
        foodDataHandler = (FoodDataHandler) foodDataHandlerFactory.createDataHandler();
        foodDataHandler.loadAllData();
    }

    private void removeMenuItem(int componentNumber) throws MenuException
    {
        removedItemID = menu.getItemID(componentNumber);
        menu.RemoveItem(componentNumber);
    }

    private void loadMenu() throws Exception
    {
        menu = new RestaurantMenu(restaurant.getPhone());
        menuDataHandler.setObject(menu);
        menu = (Menu) menuDataHandler.loadFullObject();
    }

    private void updateMenuData() throws Exception
    {
        menuDataHandler.setObject(menu);
        menuDataHandler.updateObject();
    }

    private void updateFoodData() throws Exception
    {
        Food food = new MainDish(removedItemID); //type doesn't matter for the data handler
        foodDataHandler.setObject(food);
        foodDataHandler.removeObject();
    }
}
