package userinterfacecomponentutil.restaurantmenucomponentutil;

import loggingutil.Logger;
import menuutil.Menu;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.OnsiteRestaurant;
import usersutil.Restaurant;

import java.util.ArrayList;

public class ViewSitesComponent extends UserInterfaceComponent
{
    public ViewSitesComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance();

        if(!(logger.getUser() instanceof OnsiteRestaurant))
            throw new Exception("No Sites Available Since This Restaurant is not Onsite");

        OnsiteRestaurant restaurant = (OnsiteRestaurant) logger.getUser();
        ArrayList<String> sites = restaurant.getSites();

        if(sites.isEmpty())
            throw new Exception("No Sites Available");

        int id = 1;
        for(String item : sites)
        {
            System.out.println(id + ") " + item);
            id++;
        }

        System.out.println("------------------------");
    }
}
