package userinterfacecomponentutil.maininterfaceutil;

import dataloaders.user.UserDataDummyLoader;
import dataloaders.user.UserDataLoader;
import logger.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
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

        Logger logger = Logger.getInstance(null);
        UserDataLoader dataLoader = new UserDataDummyLoader(user);

        logger.signIn(dataLoader);

    }
}
