package dataloaders.orderutil;

import foodutil.Food;
import foodutil.MainDish;
import orderutil.FoodOrder;
import orderutil.Order;
import users.User;

import java.util.ArrayList;

public class OrderDummyDataLoader extends OrderDataLoader
{
    public OrderDummyDataLoader(User user)
    {
        super(user);
    }

    @Override
    public void saveAllData() {

    }

    @Override
    public void loadAllData()
    {
        ArrayList<Food> foods = new ArrayList<>();
        Food food = new MainDish("A", "A", "A", 1.2);
        foods.add(food);
        food = new MainDish("B", "B", "B", 1.2);
        foods.add(food);

        Order order = new FoodOrder(user, user, foods, "1");
        orders.add(order);
        order = new FoodOrder(user, user, foods, "2");
        orders.add(order);
    }

    @Override
    public void saveObject(Object object) {

    }

    @Override
    public void removeObject(Object object) {

    }

    @Override
    public Object loadFullObject()
    {
        return orders;
    }
}
