package datahandlers.foods;

import datahandlers.DataHandler;
import datahandlers.users.UserType;
import foods.Food;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public abstract class FoodDataHandler implements DataHandler
{
    protected boolean allDataLoaded;

    protected Food food;

    protected Hashtable<String, Food> foods; // a lot of adding and removing is needed as well as fast lookups

    protected Hashtable<String, FoodType> foodTypes; // a lot of adding and removing is needed as well as fast lookups

    FoodDataHandler()
    {
        food = null;
        foods = new Hashtable<>();
        foodTypes = new Hashtable<>();
        allDataLoaded = false;
    }

    @Override
    public void setObject(Object object)
    {
        this.food = (Food) object;
    }

    @Override
    public void alertUpdate()
    {
        allDataLoaded = false;
    }
}
