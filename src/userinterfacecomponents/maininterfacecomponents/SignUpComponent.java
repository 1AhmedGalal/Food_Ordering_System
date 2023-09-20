package userinterfacecomponents.maininterfacecomponents;

import datahandlers.users.UserDataDummyHandler;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserFileHandler;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
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
        UserDataHandler userDataHandler = new UserFileHandler(user); //needs Factory
        Logger logger = Logger.getInstance(userDataHandler);

        logger.signUp();

    }
}
