package userinterfacecomponents.admincomponents;

import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.maininterfacecomponents.DeleteAccountComponent;
import users.NormalUser;
import users.User;

import java.util.Scanner;

public class RemoveUserComponent extends UserInterfaceComponent
{

    public RemoveUserComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        System.out.println("Enter The Phone of Restaurant/User : ");
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.next();

        User user = new NormalUser(phone); //type of user doesn't matter as it will be determined by the data handlers

        DeleteAccountComponent deleteAccountComponent = new DeleteAccountComponent("delete account", user);
        deleteAccountComponent.doWork();
    }
}
