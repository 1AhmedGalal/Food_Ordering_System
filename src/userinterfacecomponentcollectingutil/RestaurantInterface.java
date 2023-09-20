package userinterfacecomponentcollectingutil;

import dataloaders.restaurantinterfaceutil.RestaurantInterfaceDataLoader;
import dataloaders.restaurantinterfaceutil.RestaurantInterfaceDummyDataLoader;

public class RestaurantInterface extends UserInterfaceCollector
{
    public RestaurantInterface()
    {
        super();
        RestaurantInterfaceDataLoader restaurantInterfaceDataLoader = new RestaurantInterfaceDummyDataLoader(this);
        restaurantInterfaceDataLoader.loadAllData();
    }

}
