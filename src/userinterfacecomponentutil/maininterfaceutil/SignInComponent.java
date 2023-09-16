package userinterfacecomponentutil.maininterfaceutil;

import datasavingutil.userutil.UserDataDummyLoader;
import datasavingutil.userutil.UserDataLoader;
import loggingutil.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.NormalUser;
import usersutil.User;

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
        UserDataLoader dataLoader = new UserDataDummyLoader(user);

        logger.signIn(dataLoader);

    }
}
