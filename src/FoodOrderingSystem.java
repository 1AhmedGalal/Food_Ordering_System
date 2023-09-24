import datahandlers.DataHandlerException;
import datahandlers.foods.FoodDataHandler;
import datahandlers.foods.FoodDataHandlerFactory;
import datahandlers.foods.FoodFileHandler;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserFileHandler;
import foods.Appetizer;
import foods.Food;
import foods.MainDish;
import menu.Menu;
import menu.MenuException;
import menu.RestaurantMenu;
import userinterfacecollectors.MainInterface;
import userinterfacecollectors.UserInterfaceCollector;

public class FoodOrderingSystem
{
    public static void main(String[] args)
    {
        try
        {
            UserInterfaceCollector mainInterface = new MainInterface();
            mainInterface.display();
        }
        catch (Exception e)
        {
            System.out.println("Failed To Load The System!");
        }
    }
}
