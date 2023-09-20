package userinterfacecomponents.restaurantmenucomponentutil;

import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.OnsiteRestaurant;

import java.util.LinkedList;
import java.util.Scanner;

public class AddSiteComponent extends UserInterfaceComponent
{
    public AddSiteComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance(null);

        if(!(logger.getUser() instanceof OnsiteRestaurant))
            throw  new Exception("This restaurant is not Onsite Restaurant");

        OnsiteRestaurant restaurant = (OnsiteRestaurant) logger.getUser();
        LinkedList<String> sites = restaurant.getSites();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Site : ");
        String site = scanner.next();
        restaurant.addSite(site);
    }
}
