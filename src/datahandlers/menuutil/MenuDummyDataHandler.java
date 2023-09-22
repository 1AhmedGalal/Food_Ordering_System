package datahandlers.menuutil;

import datahandlers.DataHandlerException;
import users.Restaurant;

public class MenuDummyDataHandler extends MenuDataHandler
{
    public MenuDummyDataHandler(Restaurant restaurant)
    {
        super(restaurant);
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
//        Food food = new MainDish("","Pizza", "Small", "Cheese pizza", 195.9);
//        try
//        {
//            menu.addItem(food);
//        }
//        catch (Exception e)
//        {
//            e.getMessage();
//        }
//
//        food = new Drink("Tea", "Large", "Red Tea", 1.9, "Glass");
//        try
//        {
//            menu.addItem(food);
//        }
//        catch (Exception e)
//        {
//            e.getMessage();
//        }
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
    public Object loadFullObject() {
        return menu;
    }
}
