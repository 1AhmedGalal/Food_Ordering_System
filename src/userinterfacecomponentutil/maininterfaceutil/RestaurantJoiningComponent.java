package userinterfacecomponentutil.maininterfaceutil;

import datasavingutil.userutil.UserDataDummyLoader;
import datasavingutil.userutil.UserDataLoader;
import loggingutil.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.NormalUser;
import usersutil.OnlineRestaurant;
import usersutil.OnsiteRestaurant;
import usersutil.User;

import java.util.ArrayList;
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
            ArrayList<String> sites = new ArrayList<>();
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

            user = new OnsiteRestaurant(name, phone, password, null, sites);

        }
        else
        {
            user = new OnlineRestaurant(name, phone, password, null);
        }

        Logger logger = Logger.getInstance();
        UserDataLoader dataLoader = new UserDataDummyLoader(user); //needs Factory

        logger.signUp(dataLoader);
    }
}
