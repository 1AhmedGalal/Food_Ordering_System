package userinterfacecomponents.admincomponentsutil;

import datahandlers.DataHandlerFactory;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserDataHandlerFactory;
import userinterfacecomponents.UserInterfaceComponent;
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
        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory(user);
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
        userDataHandler.removeObject(user);
    }
}
