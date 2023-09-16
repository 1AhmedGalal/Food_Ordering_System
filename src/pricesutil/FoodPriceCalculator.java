package pricesutil;

public class FoodPriceCalculator extends PriceCalculator
{
    private double price;
    private double discountPercentage;
    public FoodPriceCalculator(double price, double discountPercentage) throws CalculationException
    {
        this.price = price;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getResult() throws CalculationException
    {
        if(discountPercentage > 1.0 || discountPercentage < 0.0)
            throw new CalculationException("Invalid discountPercentage");

        return price - price * discountPercentage;
    }
}
