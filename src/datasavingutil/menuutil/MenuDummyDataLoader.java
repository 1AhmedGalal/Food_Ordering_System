package datasavingutil.menuutil;

import foodutil.Drink;
import foodutil.Food;
import foodutil.MainDish;
import usersutil.Restaurant;

public class MenuDummyDataLoader extends MenuDataLoader
{
    public MenuDummyDataLoader(Restaurant restaurant)
    {
        super(restaurant);
    }

    @Override
    public void saveAllData() {

    }

    @Override
    public void loadAllData()
    {
        Food food = new MainDish("Pizza", "Small", "Cheese pizza", 195.9);
        try
        {
            menu.addItem(food);
        }
        catch (Exception e)
        {
            e.getMessage();
        }

        food = new Drink("Tea", "Large", "Red Tea", 1.9, "Glass");
        try
        {
            menu.addItem(food);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void saveObject(Object object) {

    }

    @Override
    public void removeObject(Object object) {

    }

    @Override
    public Object loadFullObject() {
        return menu;
    }
}
