package offers;

public class Discount extends Offer
{
    String foodId;

    public Discount(String restaurantPhone, String foodId, double percentage)
    {
        super(restaurantPhone, percentage);
        this.foodId = foodId;
    }

    public String getFoodId()
    {
        return foodId;
    }
}
