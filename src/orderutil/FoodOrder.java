package orderutil;

import foodutil.Food;
import usersutil.Restaurant;
import usersutil.User;

import java.util.ArrayList;

public class FoodOrder extends Order
{
    public FoodOrder(User provider, User costumer, ArrayList<Food> foods, String id)
    {
        super(provider, costumer, foods, id);
    }
}
