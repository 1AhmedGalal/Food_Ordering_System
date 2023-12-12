package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerException;
import datahandlers.foods.FoodDataHandler;
import datahandlers.foods.FoodDataHandlerFactory;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import datahandlers.offers.OfferDataHandler;
import datahandlers.offers.OfferDataHandlerFactory;
import datahandlers.usersdata.UserDataHandler;
import datahandlers.usersdata.UserDataHandlerFactory;
import foods.Food;
import foods.MainDish;
import logger.Logger;
import menu.Menu;
import menu.RestaurantMenu;
import offers.Coupon;
import offers.Discount;
import offers.NullOffer;
import offers.Offer;
import pricecalculator.CalculationException;
import userinterfacecomponents.UserInterfaceComponent;
import users.NormalUser;
import users.Restaurant;
import users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class AddOfferComponent extends UserInterfaceComponent
{
    private Restaurant restaurant;

    private Menu menu;

    private Food food;

    private Offer offer;

    private MenuDataHandler menuDataHandler;

    private FoodDataHandler foodDataHandler;

    private OfferDataHandler offerDataHandler;

    private UserDataHandler userDataHandler;

    public AddOfferComponent(String message)
    {
        super(message);
        this.restaurant = null;
        this.menu = null;
        this.food = null;
        this.offer = null;
        this.foodDataHandler = null;
        this.offerDataHandler = null;
        this.menuDataHandler = null;
        this.userDataHandler = null;
    }

    @Override
    public void doWork() throws Exception
    {
        loadDataHandlers();
        loadRestaurant();
        loadMenu();

        Scanner scanner = new Scanner(System.in);
        String response = null;
        do
        {
            try
            {
                addOffer();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

            System.out.println("Would you like to continue adding offers ? (y/n)");
            response = scanner.next();
        }
        while (response.charAt(0) == 'y');
    }

    private void loadRestaurant() throws Exception
    {
        Logger logger = Logger.getInstance();
        restaurant = (Restaurant) logger.getUser();
    }

    private void loadDataHandlers() throws DataHandlerException
    {
        MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
        menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();
        menuDataHandler.loadAllData();

        FoodDataHandlerFactory foodDataHandlerFactory = new FoodDataHandlerFactory();
        foodDataHandler = (FoodDataHandler) foodDataHandlerFactory.createDataHandler();
        foodDataHandler.loadAllData();

        OfferDataHandlerFactory offerDataHandlerFactory = new OfferDataHandlerFactory();
        offerDataHandler = (OfferDataHandler) offerDataHandlerFactory.createDataHandler();
        offerDataHandler.loadAllData();

        UserDataHandlerFactory userDataHandlerFactory = new UserDataHandlerFactory();
        userDataHandler = (UserDataHandler) userDataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();


    }
    private void loadMenu() throws Exception
    {
        menu = new RestaurantMenu(restaurant.getPhone());
        menuDataHandler.setObject(menu);
        menu = (Menu) menuDataHandler.loadFullObject();
    }

    private void loadFood(String foodID) throws DataHandlerException
    {
        food = new MainDish(foodID); //type doesn't matter here (it will be corrected by the data handler)
        foodDataHandler.setObject(food);
        food = (Food) foodDataHandler.loadFullObject();
    }

    private void displayMenu() throws CalculationException
    {
        ArrayList<String> menuItems = menu.getItemDetails();
        int id = 1;
        for(String menuItem : menuItems)
        {
            System.out.println(id + ") " + menuItem);
            id++;
        }
    }
    private void addOffer() throws Exception
    {
        System.out.println("Would you like to add 1-a discount, 2-a coupon ?");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice)
        {
            case 1 -> addDiscount();
            case 2 -> addCoupon();
            default -> throw new Exception("Invalid Choice");
        }
    }

    private void addDiscount() throws Exception
    {
        displayMenu();

        System.out.println("Enter Item number : ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String foodID = menu.getItemID(choice);

        loadFood(foodID);

        if(!(food.getOffer() instanceof NullOffer))
            throw new Exception("Food Already has an offer");

        System.out.println("Enter discount percentage (1-100) : ");
        double percentage = scanner.nextDouble();
        percentage /= 100;

        offer = new Discount(restaurant.getPhone(), food.getFoodID(), percentage);
        food.setOffer(offer);

        foodDataHandler.setObject(food);
        foodDataHandler.updateObject();

        offerDataHandler.setObject(offer);
        offerDataHandler.saveObject();
        offer = null;
    }

    private void addCoupon() throws Exception
    {
        System.out.println("Enter discount percentage (1-100) : ");

        Scanner scanner = new Scanner(System.in);
        double percentage = scanner.nextDouble();
        percentage /= 100;

        System.out.println("Enter user phone : ");
        String userPhone = scanner.next();

        if(!isValidUser(userPhone))
            throw new Exception("Not a valid user phone");

        offer = new Coupon(restaurant.getPhone(), userPhone, percentage);

        offerDataHandler.setObject(offer);
        offerDataHandler.saveObject();
        offer = null;
    }

    private boolean isValidUser(String userPhone)
    {
        boolean userExists = true;
        User user = null;

        try
        {
            user = new NormalUser(userPhone);
            userDataHandler.setObject(user);
            user = (User) userDataHandler.loadFullObject();
        }
        catch (Exception e)
        {
            userExists = false;
        }

        return userExists && (user instanceof NormalUser);
    }

}
