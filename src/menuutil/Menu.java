package menuutil;

import foods.Food;

import java.util.ArrayList;

public abstract class Menu
{
    ArrayList<Food> foods;

    public Menu()
    {
        foods = new ArrayList<>();
    }

    public void addItem(Food food) throws MenuException
    {
        if(foods.contains(food))
            throw new MenuException("Food Already Exists");

        foods.add(food);
    }

    public void RemoveItem(int choice) throws MenuException
    {
        choice--;

        if(!isValidChoice(choice))
            throw new MenuException("Not A Valid Choice");

        Food currentFodd = foods.get(choice);
        foods.remove(currentFodd);
    }

    public ArrayList<String> getItemsNames()
    {
        ArrayList<String> items = new ArrayList<>();

        for(Food food : foods)
            items.add(food.getName());

        return items;
    }

    public Food getItem(int choice) throws MenuException
    {
        choice--;

        if(!isValidChoice(choice))
            throw new MenuException("Not A Valid Choice");

        return foods.get(choice);
    }

    protected boolean isValidChoice(int choice)
    {
        return choice >= 0 && choice < foods.size();
    }
}
