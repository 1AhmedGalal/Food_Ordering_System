package userinterfacecomponents.maininterfacecomponents;

import datahandlers.DataHandlerFactory;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserDataHandlerFactory;
import datahandlers.users.UserFileHandler;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.OnlineRestaurant;
import users.OnsiteRestaurant;
import users.User;

import java.util.LinkedList;
import java.util.Scanner;

public class RestaurantJoiningComponent extends UserInterfaceComponent
{
    public RestaurantJoiningComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        String name;
        System.out.println("Name : ");
        name = scanner.next();

        String phone;
        System.out.println("Phone : ");
        phone = scanner.next();

        String password;
        System.out.println("Password : ");
        password = scanner.next();

        int choice;
        System.out.println("Choose 1 if you are an online restaurant and any other number for onsite restaurant");
        choice = scanner.nextInt();

        User user = null;
        if(choice != 1)
        {
            LinkedList<String> sites = new LinkedList<>();
            String site;

            do
            {
                System.out.println("Please Enter Your Restaurant Site");
                site = scanner.next();
                sites.add(site);

                System.out.println("Choose 1 to continue entering sites and any other number to exit");
                choice = scanner.nextInt();

            }
            while (choice == 1);

            user = new OnsiteRestaurant(name, phone, password, sites);

        }
        else
        {
            user = new OnlineRestaurant(name, phone, password);
        }

        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
        Logger logger = Logger.getInstance(userDataHandler);

        logger.signUp();
    }
}
