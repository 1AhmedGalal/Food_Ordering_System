package datasavingutil.userinterfaceutil;

import datasavingutil.DataLoader;
import userinterfacecomponentcollectingutil.AdminInterface;
import userinterfacecomponentcollectingutil.UserInterface;

public abstract class UserInterfaceDataLoader implements DataLoader
{
    UserInterface userInterface;

    public UserInterfaceDataLoader(UserInterface userInterface)
    {
        this.userInterface = userInterface;
    }
}
