package userinterfacecomponentutil;

public abstract class UserInterfaceComponent
{
    protected String message;

    public UserInterfaceComponent(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }

    public abstract void doWork() throws Exception;
}
