package menu;

import foods.Drink;
import foods.Food;
import offers.Discount;
import offers.NullOffer;
import pricecalculator.CalculationException;

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

    public ArrayList<String> getItemDetails() throws CalculationException
    {
        ArrayList<String> items = new ArrayList<>();

        for(Food food : foods)
        {
            String price = null;
            if(food.getOffer() instanceof Discount)
                price = ", Price : " + food.getNetPrice() + "(Price Before Discount : " + food.getOriginalPrice() + ")";
            else
                price = ", Price : " + food.getNetPrice();

            String detail = "Name : " + food.getName() + price + ", Size : " + food.getSize() + ", Details : " +  food.getDescription();

            if(food instanceof Drink)
                detail += ", " + ((Drink) food).getCupType();

            items.add(detail);
        }

        return items;
    }

    public ArrayList<String> getItemIDs()
    {
        ArrayList<String> items = new ArrayList<>();

        for(Food food : foods)
            items.add(food.getFoodID());

        return items;
    }
    public String getItemID(int choice) throws MenuException
    {
        choice--;

        if(!isValidChoice(choice))
            throw new MenuException("Not A Valid Choice");

        return foods.get(choice).getFoodID();
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

            if(currentFood.equals(food))
                return true;
        }

        return false;
    }
}
