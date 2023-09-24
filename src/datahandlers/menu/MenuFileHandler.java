package datahandlers.menu;

import datahandlers.DataHandlerException;
import datahandlers.foods.FoodDataHandler;
import datahandlers.foods.FoodDataHandlerFactory;
import datahandlers.users.UserType;
import foods.Food;
import foods.MainDish;
import menu.Menu;
import menu.RestaurantMenu;
import users.NormalUser;
import users.OnlineRestaurant;
import users.OnsiteRestaurant;
import users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class MenuFileHandler extends MenuDataHandler
{
    public MenuFileHandler()
    {
        super();
    }

    @Override
    public void setObject(Object object)
    {
        this.menu = (Menu) object;
    }

    @Override
    public void saveAllData() throws DataHandlerException
    {
        if(!allDataLoaded) // this prevents clearing the file and losing all data
            loadAllData();

        try
        {
            clearFile(); //this is done to avoid duplicates

            BufferedWriter writer = new BufferedWriter(new FileWriter("menus.txt"));
            writer.write("=");

            Set<String> setOfPhones = menus.keySet();
            for(String phone : setOfPhones)
            {
                RestaurantMenu menu = (RestaurantMenu) menus.get(phone);

                writer.write("\n" + menu.getRestaurantPhone());

                ArrayList<String> menuItems = menu.getItemIDs();
                for(String menuItem : menuItems)
                    writer.write("\n" + menuItem);

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
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("menus.txt"));
            String line;

            RestaurantMenu menu = null;
            Food food = null;
            boolean firstLine = false;
            boolean restaurantMade = false;

            while((line = reader.readLine()) != null)
            {
                if(line.equals("="))
                {
                    if(restaurantMade)
                    {
                        menus.put(menu.getRestaurantPhone(), menu);
                        restaurantMade = false;
                    }

                    firstLine = true; // next line is the restaurant phone that owns this menu
                    continue;
                }

                if(firstLine)
                {
                    menu = new RestaurantMenu(line);
                    firstLine = false;
                    restaurantMade = true;
                }
                else
                {
                    food = new MainDish(line); //any type here is fine as loadFullObject() will load the correct type anyway

                    FoodDataHandlerFactory foodDataHandlerFactory = new FoodDataHandlerFactory();
                    FoodDataHandler foodDataHandler = (FoodDataHandler) foodDataHandlerFactory.createDataHandler();
                    foodDataHandler.setObject(food);

                    food = (Food) loadFullObject();
                    menu.addItem(food);
                }
            }

            reader.close();
        }
        catch (Exception e)
        {
            throw new DataHandlerException(e.getMessage());
        }

        allDataLoaded = true;
    }

    @Override
    public void alertUpdate()
    {
        allDataLoaded = false;
    }

    @Override
    public void saveObject() throws DataHandlerException
    {
        String restaurantPhone = ((RestaurantMenu) menu).getRestaurantPhone();
        menus.put(restaurantPhone, menu);

        saveAllData();
    }

    @Override
    public void removeObject() throws DataHandlerException
    {
        String restaurantPhone = ((RestaurantMenu) menu).getRestaurantPhone();

        if(!menus.containsKey(restaurantPhone))
            throw new DataHandlerException("User Not Found");

        menus.remove(restaurantPhone);
        saveAllData();
    }

    @Override
    public void updateObject() throws DataHandlerException
    {
        String restaurantPhone = ((RestaurantMenu) menu).getRestaurantPhone();

        if(!menus.containsKey(restaurantPhone))
            throw new DataHandlerException("User Not Found");

        removeObject();
        saveObject();
    }

    @Override
    public Object loadFullObject() throws DataHandlerException
    {
        return menu;
    }

    private void clearFile() throws DataHandlerException
    {
        try
        {
            FileWriter fileWriter = new FileWriter("menus.txt", false);
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
}
