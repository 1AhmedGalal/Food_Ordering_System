package userinterfacecollectors;

import datahandlers.DataHandlerException;
import datahandlers.DataHandlerFactory;
import datahandlers.maininterfaceutil.MainInterfaceDataHandler;
import datahandlers.maininterfaceutil.MainInterfaceDummyDataHandler;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserDataHandlerFactory;
import datahandlers.users.UserFileHandler;
import logger.Logger;
import users.Admin;
import users.Restaurant;
import users.User;

import java.util.Scanner;

public class MainInterface extends UserInterfaceCollector
{
    public MainInterface() throws DataHandlerException
    {
        super();
        MainInterfaceDataHandler mainInterfaceDataLoader = new MainInterfaceDummyDataHandler(this);
        mainInterfaceDataLoader.loadAllData();
    }

    @Override
    public void display() throws Exception
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
                continue;
            }

            DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
            UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
            Logger logger = Logger.getInstance(userDataHandler);
            User user = logger.getUser();

            UserInterfaceCollector userInterfaceCollector = null;

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
