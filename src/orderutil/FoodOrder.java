package orderutil;

import foodutil.Food;
import users.User;

import java.util.ArrayList;

public class FoodOrder extends Order
{
    public FoodOrder(User provider, User costumer, ArrayList<Food> foods, String id)
    {
        super(provider, costumer, foods, id);
    }
}
