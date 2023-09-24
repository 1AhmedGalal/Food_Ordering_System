package menu;

public class RestaurantMenu extends Menu
{
    protected String restaurantPhone;

    public RestaurantMenu(String restaurantPhone)
    {
        super();
        this.restaurantPhone = restaurantPhone;
    }

    public String getRestaurantPhone()
    {
        return restaurantPhone;
    }
}
