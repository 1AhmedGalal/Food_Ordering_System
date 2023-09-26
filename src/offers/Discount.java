package offers;

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
        this.offerID = restaurantPhone + foodId;
    }

    public String getFoodId()
    {
        return foodId;
    }
}
