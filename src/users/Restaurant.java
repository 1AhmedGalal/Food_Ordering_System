package users;

import menuutil.Menu;

public abstract class Restaurant extends User
{
    public Restaurant(String phone, String password)
    {
        super(phone, password);
    }

    public Restaurant(String name, String phone, String password)
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
