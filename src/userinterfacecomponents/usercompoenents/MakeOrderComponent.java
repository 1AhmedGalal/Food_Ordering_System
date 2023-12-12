package userinterfacecomponents.usercompoenents;

import datahandlers.DataHandlerException;
import datahandlers.DataHandlerFactory;
import datahandlers.foods.FoodDataHandler;
import datahandlers.foods.FoodDataHandlerFactory;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import datahandlers.offers.OfferDataHandler;
import datahandlers.offers.OfferDataHandlerFactory;
import datahandlers.order.OrderDataHandler;
import datahandlers.order.OrderDataHandlerFactory;
import datahandlers.usersdata.UserDataHandler;
import datahandlers.usersdata.UserDataHandlerFactory;
import foods.Food;
import foods.MainDish;
import logger.Logger;
import menu.Menu;
import menu.RestaurantMenu;
import offers.Coupon;
import offers.Offer;
import orders.FoodOrder;
import orders.Order;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.restaurantmenucomponents.ViewOffersComponent;
import users.OnlineRestaurant;
import users.Restaurant;
import users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class MakeOrderComponent extends UserInterfaceComponent
{
    private User user;

    private Restaurant restaurant;

    private Menu menu;

    private double totalPrice;
    private ArrayList<String> foodIDs;

    public MakeOrderComponent(String message)
    {
        super(message);
        this.user = null;
        this.restaurant = null;
        this.menu = null;
        this.totalPrice = 0.0;
        this.foodIDs = new ArrayList<>();
    }

    @Override
    public void doWork() throws Exception
    {
       loadUser();

        System.out.println("Please Enter Restaurant Phone : ");
        Scanner scanner = new Scanner(System.in);
        String restaurantPhone = scanner.next();

        loadRestaurant(restaurantPhone);
        loadMenu();

        String response = null;
        do
        {
            System.out.println("Enter Item number : ");
            int choice = scanner.nextInt();
            String foodID = menu.getItemID(choice);

            foodIDs.add(foodID);
            addFoodPrice(foodID);

            System.out.println("Would you like to continue adding food ? (y/n)");
            response = scanner.next();
        }
        while (response.charAt(0) == 'y');

        saveOrder();
    }

    private void loadUser() throws Exception
    {
        Logger logger = Logger.getInstance();
        user = logger.getUser();
    }
    private void saveOrder() throws DataHandlerException
    {
        OrderDataHandlerFactory orderDataHandlerFactory = new OrderDataHandlerFactory();
        OrderDataHandler orderDataHandler = (OrderDataHandler) orderDataHandlerFactory.createDataHandler();
        orderDataHandler.loadAllData();

        Order order = new FoodOrder(restaurant.getPhone(), user.getPhone(), foodIDs, totalPrice);
        orderDataHandler.setObject(order);
        orderDataHandler.saveObject();
    }

    private void loadRestaurant(String restaurantPhone) throws Exception
    {
        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();

        restaurant = new OnlineRestaurant(restaurantPhone);
        userDataHandler.setObject(restaurant);
        restaurant = (Restaurant) userDataHandler.loadFullObject();
    }

    private void loadMenu() throws Exception
    {

        MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
        MenuDataHandler menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();
        menuDataHandler.loadAllData();

        menu = new RestaurantMenu(restaurant.getPhone());
        menuDataHandler.setObject(menu);
        menu = (Menu) menuDataHandler.loadFullObject();

        ArrayList<String> menuItems = menu.getItemDetails();
        int id = 1;
        for(String menuItem : menuItems)
        {
            System.out.println(id + ") " + menuItem);
            id++;
        }
    }

    private void addFoodPrice(String foodID) throws Exception
    {
        FoodDataHandlerFactory foodDataHandlerFactory = new FoodDataHandlerFactory();
        FoodDataHandler foodDataHandler = (FoodDataHandler) foodDataHandlerFactory.createDataHandler();
        foodDataHandler.loadAllData();;

        Food food = new MainDish(foodID);
        foodDataHandler.setObject(food);
        food = (Food) foodDataHandler.loadFullObject();

        useCoupon(food);
        totalPrice += food.getNetPrice();
    }

    private void useCoupon(Food food) throws Exception
    {
        System.out.println("Would You like to use a coupon ? (y/n)");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);
        if(choice != 'y' && choice != 'Y')
            return;

        OfferDataHandlerFactory offerDataHandlerFactory = new OfferDataHandlerFactory();
        OfferDataHandler offerDataHandler = (OfferDataHandler) offerDataHandlerFactory.createDataHandler();
        offerDataHandler.loadAllData();;

        try
        {
            offerDataHandler.loadOffersIDs(user.getPhone());
        }
        catch (Exception e) //this means that the user has no coupons at all
        {
            return;
        }

        ViewOffersComponent viewOffersComponent = new ViewOffersComponent("view offers");
        viewOffersComponent.doWork();

        System.out.println("Please Enter Coupon ID (please note that if a coupon is used the normal discount will not be used): ");
        String couponID = scanner.next();

        Offer offer = new Coupon(couponID);
        offerDataHandler.setObject(offer);
        offer = (Offer) offerDataHandler.loadFullObject();

        if(!offer.getRestaurantPhone().equals(restaurant.getPhone()))
            throw new Exception("Invalid Restaurant");
        else if(!((Coupon) offer).getUserPhone().equals(user.getPhone()))
            throw new Exception("Invalid Coupon");
        else if(((Coupon) offer).isUsed())
            throw new Exception("Coupon Has Been Used");

        food.setOffer(offer);
        ((Coupon) offer).useCoupon();
        offerDataHandler.setObject(offer);
        offerDataHandler.updateObject();
    }
}
