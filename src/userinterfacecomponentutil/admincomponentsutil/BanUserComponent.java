package userinterfacecomponentutil.admincomponentsutil;

import datasavingutil.DataLoader;
import datasavingutil.userutil.UserDataDummyLoader;
import datasavingutil.userutil.UserDataLoader;
import datasavingutil.userutil.UserType;
import loggingutil.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.NormalUser;
import usersutil.User;

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
        UserDataLoader userDataLoader = new UserDataDummyLoader(user);

        userDataLoader.removeObject(user);
    }
}
