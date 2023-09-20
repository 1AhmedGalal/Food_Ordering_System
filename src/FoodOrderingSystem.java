import datahandlers.users.UserDataHandler;
import datahandlers.users.UserFileHandler;
import userinterfacecollectors.MainInterface;
import userinterfacecollectors.UserInterfaceCollector;

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
