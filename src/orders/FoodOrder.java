package orders;

import foods.Food;
import users.User;

import java.util.ArrayList;

public class FoodOrder extends Order
{
    public FoodOrder(String providerID, String costumerID, ArrayList<String> foodIDs, double totalPrice)
    {
        super(providerID, costumerID, foodIDs, totalPrice);
    }
}
