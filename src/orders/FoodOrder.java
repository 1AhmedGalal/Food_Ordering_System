package orders;

import java.util.ArrayList;

public class FoodOrder extends Order
{

    public FoodOrder(String orderID, String providerID, String costumerID, OrderState orderState, ArrayList<String> foodIDs, double totalPrice)
    {
        super(orderID, providerID, costumerID, orderState, foodIDs, totalPrice);
    }

    public FoodOrder(String orderID)
    {
        super(orderID);
    }

    public FoodOrder(String providerID, String costumerID, ArrayList<String> foodIDs, double totalPrice)
    {
        super(providerID, costumerID, foodIDs, totalPrice);
    }
}
