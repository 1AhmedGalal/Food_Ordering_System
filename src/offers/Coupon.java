package offers;

public class Coupon extends Offer
{
    String userPhone;

    public Coupon(String restaurantPhone, String userPhone, double percentage)
    {
        super(restaurantPhone, percentage);
        this.userPhone = userPhone;
    }

    public String getUserPhone()
    {
        return userPhone;
    }
}
