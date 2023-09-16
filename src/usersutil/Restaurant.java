package usersutil;

import menuutil.Menu;

public abstract class Restaurant extends User
{
    protected Menu menu;
    public Restaurant(String phone, String password)
    {
        super(phone, password);
    }

    public Restaurant(String name, String phone, String password, Menu menu)
    {
        super(name, phone, password);
        this.menu = menu;
    }

    public Restaurant(Restaurant restaurant)
    {
        this.name = restaurant.name;
        this.phone = restaurant.phone;
        this.password = restaurant.password;
        this.menu = restaurant.menu;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }
}
