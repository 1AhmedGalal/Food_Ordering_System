package datahandlers.offers;

import datahandlers.DataHandlerException;
import datahandlers.order.OrderFileHandler;
import offers.Coupon;
import offers.Discount;
import offers.NullOffer;
import offers.Offer;

import java.io.*;
import java.util.Set;

public class OfferFileHandler extends OfferDataHandler
{
    private String offerID;
    private String restaurantPhone;
    private double percentage;
    private String ownerID;

    private boolean isUsed;

    private static OfferFileHandler instance = null;


    public static OfferFileHandler getInstance()
    {
        if(instance == null)
            instance = new OfferFileHandler();

        return instance;
    }

    private OfferFileHandler()
    {
        offerID = null;
        restaurantPhone = null;
        percentage = 0;
        ownerID = null;
        isUsed = false;
    }

    @Override
    public void saveObject() throws DataHandlerException
    {
        OfferType offerType = getOfferType(offer);
        String offerID = offer.getOfferID();
        String restaurantPhone = offer.getRestaurantPhone();
        String ownerID = null;

        offers.put(offerID, offer);
        addOffer(restaurantPhone, offerID, restaurantDiscounts);

        if(offerType == OfferType.COUPON)
        {
            ownerID = ((Coupon) offer).getUserPhone();
            addOffer(ownerID, offerID, coupons);
        }
        else if(offerType == OfferType.DISCOUNT)
        {
            ownerID = ((Discount) offer).getFoodId();
            addOffer(ownerID, offerID, foodDiscounts);
        }

        saveAllData();
    }

    @Override
    public void removeObject() throws DataHandlerException
    {
        String offerID = offer.getOfferID();
        OfferType offerType = getOfferType(offer);

        if(!offers.containsKey(offerID))
            throw new DataHandlerException("Offer Not Found");

        offers.remove(offerID);
        removeOffer(restaurantPhone, offerID, restaurantDiscounts);

        if(offerType == OfferType.COUPON)
        {
            ownerID = ((Coupon) offer).getUserPhone();
            removeOffer(ownerID, offerID, coupons);
        }
        else if(offerType == OfferType.DISCOUNT)
        {
            ownerID = ((Discount) offer).getFoodId();
            removeOffer(ownerID, offerID, foodDiscounts);
        }

        saveAllData();
    }

    @Override
    public void updateObject() throws DataHandlerException
    {
        String offerID = offer.getOfferID();

        if(!offers.containsKey(offerID))
            throw new DataHandlerException("Offer Not Found");

        removeObject();
        saveObject();
    }

    @Override
    public Object loadFullObject() throws DataHandlerException
    {
        String offerID = offer.getOfferID();

        if(!offers.containsKey(offerID))
            throw new DataHandlerException("Offer Not Found");

        return offers.get(offerID);
    }

    @Override
    public void saveAllData() throws DataHandlerException
    {
        if(!allDataLoaded) // this prevents clearing the file and losing all data
            loadAllData();

        try
        {
            clearFile(); //this is done to avoid duplicates

            BufferedWriter writer = new BufferedWriter(new FileWriter("offers.txt"));
            writer.write("=");

            Set<String> setOfIDs = offers.keySet();
            for(String offerID : setOfIDs)
            {
                Offer offer = offers.get(offerID);
                OfferType offerType = getOfferType(offer);

                writer.write("\n" + offerType.toString());
                writer.write("\n" + offer.getOfferID());
                writer.write("\n" + offer.getRestaurantPhone());
                writer.write("\n" + Double.toString(offer.getPercentage()));
                writer.write("\n" + getOwnerID(offer));

                if(offerType == OfferType.COUPON)
                    writer.write("\n" + Boolean.toString( ((Coupon) offer).isUsed()) );

                writer.write("\n" + "=");
            }

            writer.close();
        }
        catch (IOException e)
        {
            throw new DataHandlerException(e.getMessage());
        }

        alertUpdate();
    }

    public void loadAllData() throws DataHandlerException
    {
        if(allDataLoaded)
            return;

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("offers.txt"));
            String line;

            Offer offer = null;
            OfferType offerType = null;

            int cnt = 0;

            while((line = reader.readLine()) != null)
            {
                if(line.equals("="))
                {
                    if(cnt != 0) //makes sure that this "=" is not the beginning of the file but the end of a food
                    {
                        offer = makeOffer(offerType);
                        offers.put(offerID, offer);

                        addOffer(restaurantPhone, offerID, restaurantDiscounts);

                        if(offerType == OfferType.COUPON)
                            addOffer(ownerID, offerID, coupons);
                        else if(offerType == OfferType.DISCOUNT)
                            addOffer(ownerID, offerID, foodDiscounts);
                    }

                    cnt = 0;
                    continue;
                }

                switch (cnt)
                {
                    case 0:
                        offerType = getOfferType(line);
                        break;

                    case 1:
                        offerID = line;
                        break;

                    case 2:
                        restaurantPhone = line;
                        break;

                    case 3:
                        percentage = Double.parseDouble(line);
                        break;

                    case 4:
                        ownerID = line;
                        break;

                    default: // extra lines is for coupons
                        isUsed = Boolean.parseBoolean(line);
                        break;
                }

                cnt++;
            }

            reader.close();
        }
        catch (Exception e)
        {
            throw new DataHandlerException(e.getMessage());
        }

        allDataLoaded = true;
    }

    private void clearFile() throws DataHandlerException
    {
        try
        {
            FileWriter fileWriter = new FileWriter("offers.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter, false);
            printWriter.flush();
            printWriter.close();
            fileWriter.close();
        }
        catch (Exception e)
        {
            throw new DataHandlerException(e.getMessage());
        }
    }

    private Offer makeOffer(OfferType offerType)
    {
        if(offerType == OfferType.DISCOUNT)
        {
            return new Discount(restaurantPhone, ownerID, percentage, offerID);
        }
        else if(offerType == OfferType.COUPON)
        {
            Coupon coupon = new Coupon(restaurantPhone, ownerID, percentage, offerID);

            if(isUsed)
            {
                coupon.useCoupon();
            }

            return coupon;
        }
        else
        {
            return new NullOffer(restaurantPhone);
        }
    }
}
