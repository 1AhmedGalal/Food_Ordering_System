package foods;

public class Drink extends Food
{
    protected String cupType;

    public Drink(String restaurantPhone, String name, String size, String description, double price, String cupType)
    {
        super(restaurantPhone, name, size, description, price);
        this.cupType = cupType;
    }

    public String getCupType()
    {
        return cupType;
    }
}
