package users;

public class OnlineRestaurant extends Restaurant
{
    public OnlineRestaurant()
    {
        super();
    }

    public OnlineRestaurant(String phone) throws UserException
    {
        super(phone);
    }

    public OnlineRestaurant(String phone, String password) throws UserException
    {
        super(phone, password);
    }

    public OnlineRestaurant(Restaurant restaurant)
    {
        super(restaurant);
    }

    public OnlineRestaurant(String name, String phone, String password) throws UserException {
        super(name, phone, password);
    }
}
