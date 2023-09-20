package users;

import menuutil.Menu;

public abstract class Restaurant extends User
{
    public Restaurant(String phone, String password) throws UserException
    {
        super(phone, password);
    }

    public Restaurant(String name, String phone, String password) throws UserException
    {
        super(name, phone, password);
    }

    public Restaurant(Restaurant restaurant)
    {
        this.name = restaurant.name;
        this.phone = restaurant.phone;
        this.password = restaurant.password;
    }

}
