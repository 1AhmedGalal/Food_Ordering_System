package offers;

public abstract class Offer
{
    String offerID;

    protected String restaurantPhone;
    protected double percentage;

    public Offer(String offerID)
    {
        this.offerID = offerID;
    }

    public Offer(String restaurantPhone, double percentage)
    {
        this.restaurantPhone = restaurantPhone;
        this.percentage = percentage;
        offerID = null;
    }

    public String getRestaurantPhone()
    {
        return restaurantPhone;
    }

    public double getPercentage()
    {
        return percentage;
    }

    public String getOfferID() {
        return offerID;
    }
}
