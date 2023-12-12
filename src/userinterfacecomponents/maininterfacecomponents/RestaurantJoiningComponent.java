package userinterfacecomponents.maininterfacecomponents;

import datahandlers.DataHandlerException;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import logger.Logger;
import menu.Menu;
import menu.RestaurantMenu;
import userinterfacecomponents.UserInterfaceComponent;
import users.OnlineRestaurant;
import users.OnsiteRestaurant;
import users.User;
import users.UserException;

import java.util.LinkedList;
import java.util.Scanner;

public class  RestaurantJoiningComponent extends UserInterfaceComponent
{
    private String name;

    private String phone;

    private String password;

    private User user;

    public RestaurantJoiningComponent(String message)
    {
        super(message);
        name = null;
        phone = null;
        password = null;
        user = null;
    }

    @Override
    public void doWork() throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name : ");
        name = scanner.nextLine();

        System.out.println("Phone : ");
        phone = scanner.next();

        System.out.println("Password : ");
        password = scanner.next();

        if(name == null || phone == null || password == null)
            throw new Exception("Invalid data. Please Enter All Fields");
        else if(password.length() < 8)
            throw new Exception("Invalid password (minimum length is 8)");
        else if(phone.length() < 11)
            throw new Exception("Invalid phone");

        int choice;
        System.out.println("Choose 1 if you are an online restaurant and any other number for onsite restaurant");
        choice = scanner.nextInt();

        if(choice == 1)
            makeOnlineRestaurant();
        else
            makeOnsiteRestaurant();

        addUser();
        addMenu();
    }

    private void makeOnsiteRestaurant() throws UserException
    {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        LinkedList<String> sites = new LinkedList<>();
        String site;

        do
        {
            System.out.println("Please Enter Your Restaurant Site");

            if(choice == 1)
                scanner.skip("\n");

            site = scanner.nextLine();
            sites.add(site);

            System.out.println("Choose 1 to continue entering sites and any other number to exit");
            choice = scanner.nextInt();
        }
        while (choice == 1);

        user = new OnsiteRestaurant(name, phone, password, sites);
    }

    private void makeOnlineRestaurant() throws UserException
    {
        user = new OnlineRestaurant(name, phone, password);
    }

    private void addUser() throws Exception
    {
        Logger logger = Logger.getInstance();
        logger.signUp(user);
    }

    private void addMenu() throws DataHandlerException
    {
        MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
        MenuDataHandler menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();
        menuDataHandler.loadAllData();

        Menu menu = new RestaurantMenu(user.getPhone());
        menuDataHandler.setObject(menu);
        menuDataHandler.saveObject();
    }
}
