package userinterfacecomponentutil.maininterfaceutil;

import datahandlers.users.UserDataDummyHandler;
import datahandlers.users.UserDataHandler;
import logger.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
import users.NormalUser;
import users.User;

import java.util.Scanner;

public class SignUpComponent extends UserInterfaceComponent
{
    public SignUpComponent(String message)
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

        User user = new NormalUser(name, phone, password);
        UserDataHandler dataLoader = new UserDataDummyHandler(user); //needs Factory
        Logger logger = Logger.getInstance(dataLoader);

        logger.signUp();

    }
}
