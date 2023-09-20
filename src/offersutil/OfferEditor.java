package offersutil;

import datahandlers.DataHandler;
import foodutil.Food;
import users.Restaurant;
import users.User;

import java.util.ArrayList;

public abstract class OfferEditor
{
    Restaurant restaurant;
    ArrayList<Offer> offers;
    DataHandler dataHandler;

    public OfferEditor(Restaurant restaurant, DataHandler dataHandler)
    {
        this.restaurant = restaurant;
        this.dataHandler = dataHandler;
        offers = new ArrayList<>();
        dataHandler.loadAllData();
    }

    public void addDiscount(Food food, double percentage)
    {
        Offer offer = new Discount(restaurant, percentage, food);
        offers.add(offer);
    }

    public void editDiscount(Food food, double percentage)
    {

    }

    public void removeDiscount(Food food)
    {

    }

    public void addCoupon(User user, double percentage)
    {

    }

    public void editCoupon(User user, double percentage)
    {

    }

    public void removeCoupon(User user)
    {

    }
}
