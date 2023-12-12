package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerException;
import datahandlers.offers.OfferDataHandler;
import datahandlers.offers.OfferDataHandlerFactory;
import logger.Logger;
import offers.Coupon;
import offers.Discount;
import offers.NullOffer;
import offers.Offer;
import userinterfacecomponents.UserInterfaceComponent;
import users.User;

import java.util.LinkedList;

public class ViewOffersComponent extends UserInterfaceComponent
{
    private User user;
    public ViewOffersComponent(String message)
    {
        super(message);
        this.user = null;
    }

    @Override
    public void doWork() throws Exception
    {
        loadUser();
        LinkedList<String> offers = loadOffers();

        for(String offer : offers)
            System.out.println(offer);
    }

    private void loadUser() throws Exception
    {
        Logger logger = Logger.getInstance();
        user = logger.getUser();
    }

    private LinkedList<String> loadOffers() throws DataHandlerException
    {
        OfferDataHandlerFactory offerDataHandlerFactory = new OfferDataHandlerFactory();
        OfferDataHandler offerDataHandler = (OfferDataHandler) offerDataHandlerFactory.createDataHandler();

        offerDataHandler.loadAllData();
        LinkedList<String> offerIDs = offerDataHandler.loadOffersIDs(user.getPhone());

        LinkedList<String> offerDetails = new LinkedList<>();
        int id = 1;
        for(String offerID : offerIDs)
        {
            Offer offer = new Discount(offerID); //type doesn't matter
            offerDataHandler.setObject(offer);
            offer = (Offer) offerDataHandler.loadFullObject();

            offerDetails.add(id + ") Discount Percentage : " + offer.getPercentage()*100 + "%, ID : " + offer.getOfferID());
            offerDetails.add("   " + "Type : " + getOfferType(offer) + ", Restaurant Phone : " + offer.getRestaurantPhone());

            if(offer instanceof Coupon)
            {
                String state = null;
                if(((Coupon) offer).isUsed())
                    state = "Used";
                else
                    state = "Not Used";

                offerDetails.add("   " + "State : " + state);
            }

            id++;
        }

        return offerDetails;
    }

    private String getOfferType(Offer offer)
    {
        if(offer instanceof Discount)
            return "Discount";
        else if(offer instanceof Coupon)
            return "Coupon";

        return "Unknown";
    }
}
