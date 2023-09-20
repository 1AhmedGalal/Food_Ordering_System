package userinterfacecomponentutil.admincomponentsutil;

import dataloaders.user.UserDataDummyLoader;
import dataloaders.user.UserDataLoader;
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
        UserDataLoader userDataLoader = new UserDataDummyLoader(user);

        userDataLoader.removeObject(user);
    }
}
