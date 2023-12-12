package orders;

import foods.Food;
import users.User;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public abstract class Order
{
    String orderID;
    protected String providerID;
    protected String costumerID;
    protected OrderState orderState;
    protected ArrayList<String> foodIDs;
    protected double totalPrice;

    //should be used by data handler only
    public Order(String orderID, String providerID, String costumerID, OrderState orderState, ArrayList<String> foodIDs, double totalPrice)
    {
        this.orderID = orderID;
        this.providerID = providerID;
        this.costumerID = costumerID;
        this.orderState = orderState;
        this.totalPrice = totalPrice;

        this.foodIDs = new ArrayList<>();
        this.foodIDs.addAll(foodIDs);
    }

    //used in the interface when you don't know the full order
    public Order(String orderID)
    {
        this.orderID = orderID;
    }

    public Order(String providerID, String costumerID, ArrayList<String> foodIDs, double totalPrice)
    {
        this.providerID = providerID;
        this.costumerID = costumerID;
        this.foodIDs = foodIDs;
        this.totalPrice = totalPrice;
        this.orderState = OrderState.PROCESSING;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        Date date = new Date();
        String orderTime = formatter.format(date);
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
