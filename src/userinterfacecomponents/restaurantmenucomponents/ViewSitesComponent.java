package userinterfacecomponents.restaurantmenucomponents;

import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.OnsiteRestaurant;
import users.Restaurant;

import java.util.LinkedList;

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
        Restaurant restaurant = (Restaurant) logger.getUser();

        if(!(restaurant instanceof OnsiteRestaurant))
            throw new Exception("No Sites Available Since This Restaurant is not Onsite");

        LinkedList<String> sites = ((OnsiteRestaurant) restaurant).getSites();

        if(sites == null || sites.isEmpty())
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
