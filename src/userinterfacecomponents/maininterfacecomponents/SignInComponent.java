package userinterfacecomponents.maininterfacecomponents;

import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.NormalUser;
import users.User;

import java.util.Scanner;

public class SignInComponent extends UserInterfaceComponent
{
    public SignInComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        String phone;
        System.out.println("Phone : ");
        phone = scanner.next();

        String password;
        System.out.println("Password : ");
        password = scanner.next();

        User user = new NormalUser(phone, password);
        Logger logger = Logger.getInstance();
        logger.signIn(user);

    }
}
