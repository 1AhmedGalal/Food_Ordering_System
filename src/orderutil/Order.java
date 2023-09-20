package orderutil;

import foodutil.Food;
import users.User;

import java.util.ArrayList;

public abstract class Order
{
    String id;
    protected User provider;
    protected User costumer;

    protected OrderState orderState;
    protected ArrayList<Food> foods;

    protected double totalPrice;

    public Order(User provider, User costumer, ArrayList<Food> foods, String id)
    {
        this.provider = provider;
        this.costumer = costumer;
        this.foods = foods;
        this.id = id;
        this.orderState = OrderState.PROCESSING;
    }

    public User getProvider()
    {
        return provider;
    }

    public User getCostumer()
    {
        return costumer;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public OrderState getOrderState()
    {
        return orderState;
    }

    protected void setOrderState(OrderState orderState)
    {
        this.orderState = orderState;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id : '" + id + '\'' +
                ", provider : " + provider +
                ", costumer : " + costumer +
                ", orderState : " + getOrderStateName() +
                ", foods : " + getFoodNames() +
                ", totalPrice: " + totalPrice +
                '}';
    }

    protected String getFoodNames()
    {
        String names = "";
        for(Food food : foods)
            names = names + " " + food.getName();

        return names;
    }

    protected String getOrderStateName()
    {
        String name;

        if(this.orderState == orderState.PROCESSING)
            name = "Processing";
        else if(this.orderState == orderState.DELIVERED)
            name = "Delivered";
        else
            name = "Canceled";

        return name;
    }

    public String getId()
    {
        return id;
    }
}
