package datasavingutil.admininterfaceutil;

import datasavingutil.DataLoader;
import userinterfacecomponentcollectingutil.AdminInterface;
import userinterfacecomponentcollectingutil.RestaurantInterface;

public abstract class AdminInterfaceDataLoader implements DataLoader
{
    AdminInterface adminInterface;

    public AdminInterfaceDataLoader(AdminInterface adminInterface)
    {
        this.adminInterface = adminInterface;
    }
}
