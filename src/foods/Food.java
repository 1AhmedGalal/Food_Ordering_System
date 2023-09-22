package foods;

import offers.Discount;
import offers.NullOffer;
import offers.Offer;
import pricecalculator.CalculationException;
import pricecalculator.PriceCalculator;

public abstract class Food
{
    protected String foodID;

    protected String name;
    protected String size;

    protected String description;

    protected double price;

    protected String restaurantPhone;

    protected Offer offer;

    public Food(String restaurantPhone, String name, String size, String description, double price)
    {
        this.restaurantPhone = restaurantPhone;
        this.name = name;
        this.size = size;
        this.description = description;
        this.price = price;
        this.foodID = restaurantPhone + name;
        offer = new NullOffer(restaurantPhone);
    }

    public String getName()
    {
        return name;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size) throws FoodException
    {
        if(name == null)
            throw new FoodException("Invalid Name");

        this.size = size;
    }

    public double getPrice() throws CalculationException
    {
        double discountPercentage = offer.getPercentage();
        return PriceCalculator.calculatePrice(price, discountPercentage);
    }

    public void setPrice(double price) throws FoodException
    {
        if(price <= 0)
            throw new FoodException("Invalid price");

        this.price = price;
    }

    public Offer getOffer()
    {
        return offer;
    }

    public void setOffer(Offer offer)
    {
        this.offer = offer;
    }


}
