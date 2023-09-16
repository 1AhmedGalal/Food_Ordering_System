package userinterfacecomponentutil.restaurantmenucomponentutil;

import datasavingutil.DataLoader;
import datasavingutil.userutil.UserDataDummyLoader;
import datasavingutil.userutil.UserDataLoader;
import loggingutil.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.OnlineRestaurant;
import usersutil.OnsiteRestaurant;
import usersutil.Restaurant;
import usersutil.User;

import java.util.ArrayList;
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
        Logger logger = Logger.getInstance();

        if(!(logger.getUser() instanceof OnsiteRestaurant))
            throw  new Exception("This restaurant is not Onsite Restaurant");

        OnsiteRestaurant restaurant = (OnsiteRestaurant) logger.getUser();
        ArrayList<String> sites = restaurant.getSites();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Site : ");
        String site = scanner.next();
        restaurant.addSite(site);
    }
}
