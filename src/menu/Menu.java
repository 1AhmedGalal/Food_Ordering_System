package menu;

import foods.Food;

import java.util.ArrayList;

public abstract class Menu
{
    protected ArrayList<Food> foods; //modifying the menu is less frequent than lookups so array list is better here
    public Menu()
    {
        foods = new ArrayList<>();
    }

    public void addItem(Food food) throws MenuException
    {
        if(foodExists(food))
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

    public ArrayList<String> getItemIDs()
    {
        ArrayList<String> items = new ArrayList<>();

        for(Food food : foods)
            items.add(food.getFoodID());

        return items;
    }
    public Food getItem(int choice) throws MenuException
    {
        choice--;

        if(!isValidChoice(choice))
            throw new MenuException("Not A Valid Choice");

        return foods.get(choice);
    }

    private boolean isValidChoice(int choice)
    {
        return choice >= 0 && choice < foods.size();
    }

    private boolean foodExists(Food food)
    {
        for(Food currentFood : foods)
        {
            String currentFoodName = currentFood.getName();
            String foodName = currentFood.getName();

            if(currentFoodName.equals(foodName))
                return true;
        }

        return false;
    }
}
