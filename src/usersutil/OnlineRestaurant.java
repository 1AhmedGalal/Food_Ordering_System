package usersutil;

import menuutil.Menu;

public class OnlineRestaurant extends Restaurant
{
    public OnlineRestaurant(String phone, String password)
    {
        super(phone, password);
    }

    public OnlineRestaurant(Restaurant restaurant)
    {
        super(restaurant);
    }
    public OnlineRestaurant(String name, String phone, String password, Menu menu)
    {
        super(name, phone, password, menu);
    }
}
