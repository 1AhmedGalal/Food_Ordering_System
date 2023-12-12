package offers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Discount extends Offer
{
    String foodId;

    public Discount(String offerID)
    {
        super(offerID);
        foodId = null;
    }

    public Discount(String restaurantPhone, String foodId, double percentage)
    {
        super(restaurantPhone, percentage);
        this.foodId = foodId;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        Date date = new Date();
        String offerTime = formatter.format(date);
        this.offerID = restaurantPhone + foodId + offerTime;
    }

    public Discount(String restaurantPhone, String foodId, double percentage, String offerID)
    {
        super(restaurantPhone, percentage);
        this.foodId = foodId;
        this.offerID = offerID;
    }

    public String getFoodId()
    {
        return foodId;
    }
}
