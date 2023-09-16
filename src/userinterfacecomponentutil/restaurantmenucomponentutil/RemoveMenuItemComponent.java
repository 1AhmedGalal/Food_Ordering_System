package userinterfacecomponentutil.restaurantmenucomponentutil;

import loggingutil.Logger;
import menuutil.Menu;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.Restaurant;

import java.util.Scanner;

public class RemoveMenuItemComponent extends UserInterfaceComponent
{
    public RemoveMenuItemComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Component number : ");
        int componentNumber = scanner.nextInt();

        Logger logger = Logger.getInstance();
        Restaurant restaurant = (Restaurant) logger.getUser();
        Menu menu = restaurant.getMenu();
        menu.RemoveItem(componentNumber);
    }
}
