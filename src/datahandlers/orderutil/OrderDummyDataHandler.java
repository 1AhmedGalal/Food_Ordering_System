package datahandlers.orderutil;

import datahandlers.DataHandlerException;
import users.User;

public class OrderDummyDataHandler extends OrderDataHandler
{
    public OrderDummyDataHandler(User user)
    {
        super(user);
    }

    @Override
    public void setObject(Object object) {

    }

    @Override
    public void saveAllData() {

    }

    @Override
    public void loadAllData()
    {
//        ArrayList<Food> foods = new ArrayList<>();
//        Food food = new MainDish("A", "A", "A", 1.2);
//        foods.add(food);
//        food = new MainDish("B", "B", "B", 1.2);
//        foods.add(food);
//
//        Order order = new FoodOrder(user, user, foods, "1");
//        orders.add(order);
//        order = new FoodOrder(user, user, foods, "2");
//        orders.add(order);
    }

    @Override
    public void saveObject() throws DataHandlerException {

    }

    @Override
    public void removeObject() throws DataHandlerException {

    }

    @Override
    public void updateObject() throws DataHandlerException {

    }

    @Override
    public Object loadFullObject()
    {
        return orders;
    }
}
