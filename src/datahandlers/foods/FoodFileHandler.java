package datahandlers.foods;

import datahandlers.DataHandlerException;
import datahandlers.maininterface.MainInterfaceDummyDataHandler;
import foods.Appetizer;
import foods.Drink;
import foods.Food;
import foods.MainDish;

import java.io.*;
import java.util.Set;

public class FoodFileHandler extends FoodDataHandler
{
    private String foodID;
    private String restaurantPhone;
    private String name;
    private String size;
    private String price;
    private String  description;

    private String cupType;

    private static FoodFileHandler instance = null;


    public static FoodFileHandler getInstance()
    {
        if(instance == null)
            instance = new FoodFileHandler();

        return instance;
    }

    private FoodFileHandler()
    {
        super();
    }

    @Override
    public void saveObject() throws DataHandlerException
    {
        FoodType foodType = null;

        if(food instanceof MainDish)
            foodType = FoodType.MAIN_DISH;
        else if(food instanceof Appetizer)
            foodType = FoodType.APPETIZER;
        else
            foodType = FoodType.DRINK;

        String foodID = food.getFoodID();
        foods.put(foodID, food);
        foodTypes.put(foodID, foodType);

        saveAllData();
    }

    @Override
    public void removeObject() throws DataHandlerException
    {
        String foodID = food.getFoodID();

        if(!foods.containsKey(foodID))
            throw new DataHandlerException("Food Not Found");

        foods.remove(foodID);
        foodTypes.remove(foodID);
        saveAllData();
    }

    @Override
    public void updateObject() throws DataHandlerException
    {
        String foodID = food.getFoodID();

        if(!foods.containsKey(foodID))
            throw new DataHandlerException("Food Not Found");

        removeObject();
        saveObject();
    }

    @Override
    public Object loadFullObject() throws DataHandlerException
    {
        String foodID = food.getFoodID();

        if(!foods.containsKey(foodID))
            throw new DataHandlerException("Food Not Found");

        return foods.get(foodID);
    }

    @Override
    public void saveAllData() throws DataHandlerException
    {
        if(!allDataLoaded) // this prevents clearing the file and losing all data
            loadAllData();

        try
        {
            clearFile(); //this is done to avoid duplicates

            BufferedWriter writer = new BufferedWriter(new FileWriter("foods.txt"));
            writer.write("=");

            Set<String> setOfIDs = foods.keySet();
            for(String foodID : setOfIDs)
            {
                Food food = foods.get(foodID);
                FoodType foodType = foodTypes.get(foodID);

                writer.write("\n" + foodType.toString());
                writer.write("\n" + food.getFoodID());
                writer.write("\n" + food.getRestaurantPhone());
                writer.write("\n" + food.getName());
                writer.write("\n" + food.getSize());
                writer.write("\n" + Double.toString(food.getOriginalPrice()));
                writer.write("\n" + food.getDescription());

                writer.write("\n" + "=");
            }

            writer.close();
        }
        catch (IOException e)
        {
            throw new DataHandlerException(e.getMessage());
        }

        allDataLoaded = false;
    }

    @Override
    public void loadAllData() throws DataHandlerException
    {
        if(allDataLoaded)
            return;

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("foods.txt"));
            String line;

            Food food = null;
            FoodType foodType = null;

            int cnt = 0;

            while((line = reader.readLine()) != null)
            {
                if(line.equals("="))
                {
                    if(cnt != 0) //makes sure that this "=" is not the beginning of the file but the end of a food
                    {
                        food = makeFood(foodType);
                        foods.put(foodID, food);
                        foodTypes.put(foodID, foodType);
                    }

                    cnt = 0;
                    continue;
                }

                switch (cnt)
                {
                    case 0:
                        foodType = makeFoodType(line);
                        break;

                    case 1:
                        foodID = line;
                        break;

                    case 2:
                        restaurantPhone = line;
                        break;

                    case 3:
                        name = line;
                        break;

                    case 4:
                        size = line;
                        break;

                    case 5:
                        price = line;
                        break;

                    case 6:
                        description = line;
                        break;

                    default: //having an extra line means that this is a Drink
                        cupType = line;
                        break;
                }

                cnt++;
            }

            reader.close();
        }
        catch (Exception e)
        {
            throw new DataHandlerException(e.getMessage());
        }

        allDataLoaded = true;
    }

    private void clearFile() throws DataHandlerException
    {
        try
        {
            FileWriter fileWriter = new FileWriter("foods.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter, false);
            printWriter.flush();
            printWriter.close();
            fileWriter.close();
        }
        catch (Exception e)
        {
            throw new DataHandlerException(e.getMessage());
        }
    }

    private FoodType makeFoodType(String line)
    {
        switch (line)
        {
            case "MAIN_DISH" ->
            {
                return FoodType.MAIN_DISH;
            }
            case "APPETIZER" ->
            {
                return FoodType.APPETIZER;
            }
            default ->
            {
                return FoodType.DRINK;
            }
        }
    }

    private Food makeFood(FoodType foodType)
    {
        switch (foodType)
        {
            case MAIN_DISH ->
            {
                return new MainDish(restaurantPhone, name, size, description, Double.parseDouble(price));
            }
            case APPETIZER ->
            {
                return new Appetizer(restaurantPhone, name, size, description, Double.parseDouble(price));
            }
            default ->
            {
                return new Drink(restaurantPhone, name, size, description, Double.parseDouble(price), cupType);
            }
        }
    }
}
