package offers;

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
        this.offerID = restaurantPhone + userPhone;
        this.isUsed = false;
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
