package orders;

import foods.Food;
import users.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Order
{
    String orderID;
    protected String providerID;

    protected String costumerID;
    protected OrderState orderState;

    protected ArrayList<String> foodIDs;
    protected double totalPrice;

    public Order(String providerID, String costumerID, ArrayList<String> foodIDs, double totalPrice)
    {
        this.providerID = providerID;
        this.costumerID = costumerID;
        this.foodIDs = foodIDs;
        this.totalPrice = totalPrice;
        this.orderState = OrderState.PROCESSING;

        LocalDate orderTime = LocalDate.now();
        this.orderID = providerID + costumerID + orderTime.toString();
    }

    public void setOrderState(OrderState orderState)
    {
        this.orderState = orderState;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getProviderID() {
        return providerID;
    }

    public String getCostumerID() {
        return costumerID;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public ArrayList<String> getFoodIDs() {
        return foodIDs;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
