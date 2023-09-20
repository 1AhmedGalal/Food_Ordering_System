import datahandlers.DataHandlerException;
import datahandlers.users.UserFileHandler;
import userinterfacecomponentcollectingutil.MainInterface;
import userinterfacecomponentcollectingutil.UserInterfaceCollector;

public class FoodOrderingSystem
{
    public static void main(String[] args)
    {
        try
        {
            UserInterfaceCollector mainInterface = new MainInterface();
            mainInterface.display();
        }
        catch (Exception e)
        {
            System.out.println("Failed To Load The System!");
        }
    }
}
