package userinterfacecomponentcollectingutil;

import datahandlers.maininterfaceutil.MainInterfaceDataHandler;
import datahandlers.maininterfaceutil.MainInterfaceDummyDataHandler;
import logger.Logger;
import users.Admin;
import users.Restaurant;
import users.User;

import java.util.Scanner;

public class MainInterface extends UserInterfaceCollector
{
    public MainInterface()
    {
        super();
        MainInterfaceDataHandler mainInterfaceDataLoader = new MainInterfaceDummyDataHandler(this);
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
            //Logger logger = Logger.getInstance(null);
           // User user = logger.getUser();

            User user = null;
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
