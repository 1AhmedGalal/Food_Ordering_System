package userinterfacecollectors;

import datahandlers.restaurantinterfaceutil.RestaurantInterfaceDataHandler;
import datahandlers.restaurantinterfaceutil.RestaurantInterfaceDummyDataHandler;

public class RestaurantInterface extends UserInterfaceCollector
{
    public RestaurantInterface()
    {
        super();
        RestaurantInterfaceDataHandler restaurantInterfaceDataLoader = new RestaurantInterfaceDummyDataHandler(this);
        //restaurantInterfaceDataLoader.loadAllData();
    }

}
