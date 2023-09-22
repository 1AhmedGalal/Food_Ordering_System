package offers;

public abstract class Offer
{
    String restaurantPhone;
    double percentage;

    public Offer(String restaurantPhone, double percentage)
    {
        this.restaurantPhone = restaurantPhone;
        this.percentage = percentage;
    }

    public String getRestaurantPhone()
    {
        return restaurantPhone;
    }

    public double getPercentage()
    {
        return percentage;
    }
}
