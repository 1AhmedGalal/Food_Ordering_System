package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerException;
import datahandlers.foods.FoodDataHandler;
import datahandlers.foods.FoodDataHandlerFactory;
import datahandlers.offers.OfferDataHandler;
import datahandlers.offers.OfferDataHandlerFactory;
import logger.Logger;
import offers.Coupon;
import offers.Discount;
import offers.Offer;
import userinterfacecomponents.UserInterfaceComponent;
import users.Restaurant;

import java.util.Scanner;

public class UpdateOfferComponent extends UserInterfaceComponent
{
    private Restaurant restaurant;

    private Offer offer;

    private FoodDataHandler foodDataHandler;

    private OfferDataHandler offerDataHandler;

    public UpdateOfferComponent(String message)
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

            updateOffer(offerID);

            System.out.println("Would you like to continue editing offers ? (y/n)");
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

    void updateOffer(String offerID) throws DataHandlerException
    {
        System.out.println("Enter new discount percentage");
        Scanner scanner = new Scanner(System.in);
        double percentage = scanner.nextDouble();
        percentage /= 100;

        offer = new Discount(offerID);
        offerDataHandler.setObject(offer);
        offer = (Offer) offerDataHandler.loadFullObject();

        if(offer instanceof Coupon)
        {
            String restaurantPhone = offer.getRestaurantPhone();
            String userPhone = ((Coupon) offer).getUserPhone();
            offerID = offer.getOfferID();

            offer = new Coupon(restaurantPhone, userPhone, percentage, offerID);
        }
        else if(offer instanceof Discount)
        {
            String restaurantPhone = offer.getRestaurantPhone();
            String foodID = ((Discount) offer).getFoodId();

            offer = new Discount(restaurantPhone, foodID, percentage);
        }

        offerDataHandler.setObject(offer);
        offerDataHandler.updateObject();

        //  offerDataHandler.alertUpdate();
        foodDataHandler.alertUpdate();
    }

}
