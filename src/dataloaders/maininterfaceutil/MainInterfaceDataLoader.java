package dataloaders.maininterfaceutil;

import dataloaders.DataLoader;
import userinterfacecomponentcollectingutil.MainInterface;

public abstract class MainInterfaceDataLoader implements DataLoader
{
    MainInterface mainInterface;
    public MainInterfaceDataLoader(MainInterface mainInterface)
    {
        this.mainInterface = mainInterface;
    }
}
