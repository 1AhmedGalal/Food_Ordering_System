package foods;

import offers.Discount;
import offers.NullOffer;
import offers.Offer;
import pricecalculator.CalculationException;
import pricecalculator.PriceCalculator;

import java.util.Objects;

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
        this.foodID = restaurantPhone + name + size;
        offer = new NullOffer(restaurantPhone);
    }

    public void setPrice(double price) throws FoodException
    {
        if(price <= 0)
            throw new FoodException("Invalid price");

        this.price = price;
    }

    public void setOffer(Offer offer)
    {
        this.offer = offer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public String getFoodID() {
        return foodID;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public Offer getOffer() {
        return offer;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Food food = (Food) o;
        return Objects.equals(foodID, food.foodID);

    }

}
