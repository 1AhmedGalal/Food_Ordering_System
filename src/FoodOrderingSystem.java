import datasavingutil.DataLoader;
import datasavingutil.maininterfaceutil.MainInterfaceDummyDataLoader;
import userinterfacecomponentcollectingutil.MainInterface;
import userinterfacecomponentcollectingutil.UserInterfaceCollector;
import java.util.Scanner;

public class FoodOrderingSystem
{
    public static void main(String[] args)
    {
        UserInterfaceCollector mainInterface = new MainInterface();
        mainInterface.display();
    }
}
