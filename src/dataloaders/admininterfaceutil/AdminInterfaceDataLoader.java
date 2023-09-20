package dataloaders.admininterfaceutil;

import dataloaders.DataLoader;
import userinterfacecomponentcollectingutil.AdminInterface;

public abstract class AdminInterfaceDataLoader implements DataLoader
{
    AdminInterface adminInterface;

    public AdminInterfaceDataLoader(AdminInterface adminInterface)
    {
        this.adminInterface = adminInterface;
    }
}
