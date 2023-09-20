package userinterfacecomponents.maininterfacecomponents;

import userinterfacecomponents.UserInterfaceComponent;

public class ExitComponent extends UserInterfaceComponent
{
    public ExitComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork()
    {
        System.exit(0);
    }
}
