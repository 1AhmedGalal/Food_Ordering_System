package offers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Coupon extends Offer
{
    String userPhone;

    boolean isUsed;

    public Coupon(String offerID)
    {
        super(offerID);
        this.isUsed = false;
        this.userPhone = null;
    }

    public Coupon(String restaurantPhone, String userPhone, double percentage)
    {
        super(restaurantPhone, percentage);
        this.userPhone = userPhone;
        this.isUsed = false;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        Date date = new Date();
        String offerTime = formatter.format(date);
        this.offerID = restaurantPhone + userPhone + offerTime;
    }

    public Coupon(String restaurantPhone, String userPhone, double percentage, String offerID)
    {
        super(restaurantPhone, percentage);
        this.userPhone = userPhone;
        this.isUsed = false;
        this.offerID = offerID;
    }

    public String getUserPhone()
    {
        return userPhone;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void useCoupon()
    {
        isUsed = true;
    }
}
