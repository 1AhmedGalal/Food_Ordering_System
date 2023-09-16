package userinterfacecomponentcollectingutil;

import datasavingutil.DataLoader;
import datasavingutil.maininterfaceutil.MainInterfaceDataLoader;
import datasavingutil.maininterfaceutil.MainInterfaceDummyDataLoader;
import loggingutil.Logger;
import usersutil.Admin;
import usersutil.Restaurant;
import usersutil.User;

import java.util.Scanner;

public class MainInterface extends UserInterfaceCollector
{
    public MainInterface()
    {
        super();
        MainInterfaceDataLoader mainInterfaceDataLoader = new MainInterfaceDummyDataLoader(this);
        mainInterfaceDataLoader.loadAllData();
    }

    @Override
    public void display()
    {
        System.out.println("Welcome !");
        while(true)
        {
            this.displayComponents();
            System.out.println("-------------------------");
            System.out.println("choose option : ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            try
            {
                this.takeRequest(choice);
            }
            catch (Exception e)
            {
                System.out.println("-------------------------");
                System.out.println(e.getMessage());
                System.out.println("------------------------");
            }

            UserInterfaceCollector userInterfaceCollector = null;
            Logger logger = Logger.getInstance();
            User user = logger.getUser();

            if(user instanceof Admin)
                userInterfaceCollector = new AdminInterface();
            else if(user instanceof Restaurant)
                userInterfaceCollector = new RestaurantInterface();
            else
                userInterfaceCollector = new UserInterface();

            userInterfaceCollector.display();
        }
    }
}
