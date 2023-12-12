package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerException;
import datahandlers.foods.FoodDataHandler;
import datahandlers.foods.FoodDataHandlerFactory;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import datahandlers.offers.OfferDataHandler;
import datahandlers.offers.OfferDataHandlerFactory;
import datahandlers.order.OrderDataHandler;
import datahandlers.order.OrderDataHandlerFactory;
import foods.Appetizer;
import foods.Drink;
import foods.Food;
import foods.MainDish;
import logger.Logger;
import menu.Menu;
import menu.RestaurantMenu;
import offers.Discount;
import offers.NullOffer;
import offers.Offer;
import userinterfacecomponents.UserInterfaceComponent;
import users.Restaurant;

import java.util.Scanner;

public class EditMenuItemComponent extends UserInterfaceComponent
{
    private Restaurant restaurant;

    private Menu menu;

    private Food removedFoodItem;

    private String removedItemID;

    private Food updatedFoodItem;

    private Offer offer;

    private FoodDataHandler foodDataHandler;

    private MenuDataHandler menuDataHandler;

    private OfferDataHandler offerDataHandler;

    public EditMenuItemComponent(String message)
    {
        super(message);
        restaurant = null;
        menu = null;
        removedItemID = null;
        updatedFoodItem = null;
        offer = null;
        removedFoodItem = null;
        foodDataHandler = null;
        menuDataHandler = null;
        offerDataHandler = null;
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

        //these data will be used by later methods so loading them here is required
        loadMenu();
        getRemovedFoodItemData(componentNumber);

        System.out.print("Choose Option : 1 to change the name, 2 to change description, 3 to change size, 4 to change price");
        if(removedFoodItem instanceof Drink)
        {
            System.out.print(", 5 to change cup type");
        }
        System.out.println();

        int choice = scanner.nextInt();

        //update the food and menu data that are stored
        makeUpdatedFoodItem(choice);
        removeMenuItem(componentNumber);
        removeOldFoodData();
        updateMenuData();
    }

    private void generateDataHandlers() throws DataHandlerException
    {
        //generate menu data handler
        MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
        menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();
        menuDataHandler.loadAllData();

        //generate food data handler
        FoodDataHandlerFactory foodDataHandlerFactory = new FoodDataHandlerFactory();
        foodDataHandler = (FoodDataHandler) foodDataHandlerFactory.createDataHandler();
        foodDataHandler.loadAllData();

        //generate offer data handler
        OfferDataHandlerFactory offerDataHandlerFactory = new OfferDataHandlerFactory();
        offerDataHandler = (OfferDataHandler) offerDataHandlerFactory.createDataHandler();
        offerDataHandler.loadAllData();
    }

    private void getRemovedFoodItemData(int componentNumber) throws Exception
    {
        //first get its id from the menu
        removedItemID = menu.getItemID(componentNumber);

        //second load the object using the data handler
        removedFoodItem = new MainDish(removedItemID); //type doesn't matter for the data handler
        foodDataHandler.setObject(removedFoodItem);
        removedFoodItem = (Food) foodDataHandler.loadFullObject();
    }
    private void removeMenuItem(int componentNumber) throws Exception
    {
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
        menu.addItem(updatedFoodItem);
        menuDataHandler.setObject(menu);
        menuDataHandler.updateObject();
    }

    private void removeOldFoodData() throws Exception
    {
        foodDataHandler.loadAllData();
        foodDataHandler.setObject(removedFoodItem);
        foodDataHandler.removeObject();
    }

    void makeUpdatedFoodItem(int choice) throws Exception
    {
        // take old data from the removed item
        String name = removedFoodItem.getName();
        String description = removedFoodItem.getDescription();
        String size = removedFoodItem.getSize();
        double price = removedFoodItem.getOriginalPrice();

        String cupType = "";
        if(removedFoodItem instanceof Drink)
            cupType = ((Drink) removedFoodItem).getCupType();

        // take new changes
        Scanner scanner = new Scanner(System.in);
        switch (choice)
        {
            case 1:
                System.out.println("name : ");
                name = scanner.next();
                break;

            case 2:
                description = "";
                System.out.println("description : ");
                //scanner.skip("\n");
                description += scanner.nextLine();
                break;

            case 3:
                System.out.println("size : ");
                size = scanner.next();
                break;

            case 4:
                System.out.println("price : ");
                price = scanner.nextDouble();
                break;

            case 5:
                if(!(removedFoodItem instanceof Drink))
                    throw new Exception("Invalid Choice");

                System.out.println("Cup Type : ");
                cupType = scanner.next();
                break;

            default:
                throw new Exception("Invalid Choice");
        }

        // make the new food item
        if(removedFoodItem instanceof MainDish)
            updatedFoodItem = new MainDish(restaurant.getPhone(), name, size, description, price);
        else if(removedFoodItem instanceof Appetizer)
            updatedFoodItem = new Appetizer(restaurant.getPhone(), name, size, description, price);
        else
            updatedFoodItem = new Drink(restaurant.getPhone(), name, size, description, price, cupType);

        updateOffer();

        //add new food item (updateObject() was not used because the new food ID can differ from the old one)
        foodDataHandler.setObject(updatedFoodItem);
        foodDataHandler.saveObject();

    }

    void updateOffer() throws DataHandlerException
    {
        offer = removedFoodItem.getOffer();
        double offerPercentage = offer.getPercentage();

        offerDataHandler.setObject(offer);
        offer = (Offer) offerDataHandler.loadFullObject();

        offerDataHandler.setObject(offer);
        offerDataHandler.removeObject();

        if(!(removedFoodItem.getOffer() instanceof NullOffer))
        {
            offer = new Discount(restaurant.getPhone(), updatedFoodItem.getFoodID(), offerPercentage);
            offerDataHandler.setObject(offer);
            offerDataHandler.saveObject();
        }
        else
        {
            offer = new NullOffer(restaurant.getPhone());
        }

        updatedFoodItem.setOffer(offer);

    }
}
