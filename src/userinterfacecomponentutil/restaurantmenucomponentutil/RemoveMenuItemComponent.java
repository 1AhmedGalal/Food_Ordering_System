package userinterfacecomponentutil.restaurantmenucomponentutil;

import logger.Logger;
import menuutil.Menu;
import userinterfacecomponentutil.UserInterfaceComponent;
import users.Restaurant;

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

        Logger logger = Logger.getInstance(null);
        Restaurant restaurant = (Restaurant) logger.getUser();
        Menu menu = null; ///needs fix
        menu.RemoveItem(componentNumber);
    }
}
