package foodutil;

import offersutil.Offer;

public class Drink extends Food
{
    protected String cupType;

    public Drink(String name, String size, String description, double price, String cupType)
    {
        super(name, size, description, price);
        this.cupType = cupType;
    }
}
