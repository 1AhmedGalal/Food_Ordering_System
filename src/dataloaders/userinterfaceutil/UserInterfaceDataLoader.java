package dataloaders.userinterfaceutil;

import dataloaders.DataLoader;
import userinterfacecomponentcollectingutil.UserInterface;

public abstract class UserInterfaceDataLoader implements DataLoader
{
    UserInterface userInterface;

    public UserInterfaceDataLoader(UserInterface userInterface)
    {
        this.userInterface = userInterface;
    }
}
