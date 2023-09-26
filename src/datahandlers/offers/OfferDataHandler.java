package datahandlers.offers;

import datahandlers.DataHandler;
import datahandlers.DataHandlerException;
import offers.Coupon;
import offers.Discount;
import offers.Offer;
import java.util.Hashtable;
import java.util.LinkedList;

public abstract class OfferDataHandler implements DataHandler
{
    protected Offer offer;
    protected boolean allDataLoaded;

    protected Hashtable<String, LinkedList<String>> coupons; // key: userPhone, value: offerIDs

    protected Hashtable<String, LinkedList<String>> foodDiscounts; // key: foodID, value: offerIDs

    protected Hashtable<String, LinkedList<String>> restaurantDiscounts; // key: restaurantPhone, value: offerIDs

    protected Hashtable<String, Offer> offers; // key: offerID, value: offer
    protected Hashtable<String, OfferType> offerTypes; // key: offerID, value: offerType

    OfferDataHandler()
    {
        this.offer = null;
        this.allDataLoaded = false;
        this.coupons = new Hashtable<>();
        this.foodDiscounts = new Hashtable<>();
        this.restaurantDiscounts = new Hashtable<>();
        this.offers = new Hashtable<>();
        this.offerTypes = new Hashtable<>();
    }

    @Override
    public void setObject(Object object)
    {
        this.offer = (Offer) object;
    }

    @Override
    public void alertUpdate()
    {
        allDataLoaded = false;
    }

    public LinkedList<String> loadOffersIDs(String id) throws DataHandlerException
    {
        if(coupons.containsKey(id))
        {
            return coupons.get(id);
        }
        else if(foodDiscounts.containsKey(id))
        {
            return foodDiscounts.get(id);
        }
        else if(restaurantDiscounts.containsKey(id))
        {
            return restaurantDiscounts.get(id);
        }
        else
        {
            throw new DataHandlerException("No Data Found");
        }
    }

    protected void addOffer(String ownerID, String offerID, Hashtable<String, LinkedList<String>> container)
    {
        //when the container is empty make it first
        if(!container.containsKey(ownerID) || container.get(ownerID).isEmpty())
            container.put(ownerID, new LinkedList<String>());

        container.get(ownerID).add(offerID);
    }

    protected OfferType getOfferType(Offer offer)
    {
        if(offer instanceof Discount)
            return OfferType.DISCOUNT;
        else if(offer instanceof Coupon)
            return OfferType.COUPON;
        else
            return OfferType.NO_OFFER;
    }

    protected OfferType getOfferType(String type)
    {
        if(type.equals("DISCOUNT"))
            return OfferType.DISCOUNT;
        if(type.equals("COUPON"))
            return OfferType.COUPON;
        else
            return OfferType.NO_OFFER;
    }

    protected String getOwnerID(Offer offer)
    {
        if(offer instanceof Discount)
            return ((Discount) offer).getFoodId();
        else if(offer instanceof Coupon)
            return ((Coupon) offer).getUserPhone();
        else
            return "NO_OWNER";
    }

}
