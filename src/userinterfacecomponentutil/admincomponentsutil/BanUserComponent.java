package userinterfacecomponentutil.admincomponentsutil;

import datahandlers.users.UserDataDummyHandler;
import datahandlers.users.UserDataHandler;
import userinterfacecomponentutil.UserInterfaceComponent;
import users.NormalUser;
import users.User;

import java.util.Scanner;

public class BanUserComponent extends UserInterfaceComponent
{

    public BanUserComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter User's Phone : ");
        String phone = scanner.next();

        User user = new NormalUser(phone, null);
        UserDataHandler userDataHandler = new UserDataDummyHandler(user);

        userDataHandler.removeObject(user);
    }
}
