package pricecalculator;

public abstract class PriceCalculator
{
    public static double calculatePrice(double price, double discountPercentage) throws CalculationException
    {
        if(discountPercentage < 0 || discountPercentage > 1)
            throw new CalculationException("discount percentage should be between 0 and 1");

        return price - (price*discountPercentage);
    }
}
