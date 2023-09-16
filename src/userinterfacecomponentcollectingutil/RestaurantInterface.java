package userinterfacecomponentcollectingutil;

import datasavingutil.restaurantinterfaceutil.RestaurantInterfaceDataLoader;
import datasavingutil.restaurantinterfaceutil.RestaurantInterfaceDummyDataLoader;
import loggingutil.Logger;
import usersutil.Admin;
import usersutil.Restaurant;
import usersutil.User;

import java.util.Scanner;

public class RestaurantInterface extends UserInterfaceCollector
{
    public RestaurantInterface()
    {
        super();
        RestaurantInterfaceDataLoader restaurantInterfaceDataLoader = new RestaurantInterfaceDummyDataLoader(this);
        restaurantInterfaceDataLoader.loadAllData();
    }

}
