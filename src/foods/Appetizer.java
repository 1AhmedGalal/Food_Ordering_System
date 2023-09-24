package foods;


public class Appetizer extends Food
{

    public Appetizer(String foodID)
    {
        super(foodID);
    }
    public Appetizer(String restaurantPhone, String name, String size, String description, double price)
    {
        super(restaurantPhone, name, size, description, price);
    }
}
