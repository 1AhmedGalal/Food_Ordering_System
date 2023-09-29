package userinterfacecomponents.maininterfacecomponents;

import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.NormalUser;
import users.User;
import users.UserException;

import java.util.Scanner;

public class SignInComponent extends UserInterfaceComponent
{
    private String phone;

    private String password;

    public SignInComponent(String message)
    {
        super(message);
        phone = null;
        password = null;
    }

    @Override
    public void doWork() throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Phone : ");
        phone = scanner.next();

        System.out.println("Password : ");
        password = scanner.next();

        addUser();
    }

    private void addUser() throws Exception
    {
        User user = new NormalUser(phone, password);
        Logger logger = Logger.getInstance();
        logger.signIn(user);
    }
}
