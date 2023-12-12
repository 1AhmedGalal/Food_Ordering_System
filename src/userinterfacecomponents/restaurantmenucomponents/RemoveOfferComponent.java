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

public class RemoveOfferComponent extends UserInterfaceComponent
{
    private Restaurant restaurant;

    private Offer offer;

    private FoodDataHandler foodDataHandler;

    private OfferDataHandler offerDataHandler;

    public RemoveOfferComponent(String message)
    {
        super(message);
        this.restaurant = null;
        this.offer = null;
        this.foodDataHandler = null;
        this.offerDataHandler = null;
    }

    @Override
    public void doWork() throws Exception
    {
        loadDataHandlers();
        loadRestaurant();

        Scanner scanner = new Scanner(System.in);
        String response = null;
        do
        {
            System.out.println("Enter Offer ID : ");
            String offerID = scanner.next();

            removeOffer(offerID);

            System.out.println("Would you like to continue removing offers ? (y/n)");
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
        FoodDataHandlerFactory foodDataHandlerFactory = new FoodDataHandlerFactory();
        foodDataHandler = (FoodDataHandler) foodDataHandlerFactory.createDataHandler();
        foodDataHandler.loadAllData();

        OfferDataHandlerFactory offerDataHandlerFactory = new OfferDataHandlerFactory();
        offerDataHandler = (OfferDataHandler) offerDataHandlerFactory.createDataHandler();
        offerDataHandler.loadAllData();
    }

    void removeOffer(String offerID) throws DataHandlerException
    {
        offer = new Discount(offerID);
        offerDataHandler.setObject(offer);
        offer = (Offer) offerDataHandler.loadFullObject();

        offerDataHandler.setObject(offer);
        offerDataHandler.removeObject();

      //  offerDataHandler.alertUpdate();
        foodDataHandler.alertUpdate();
    }

}
