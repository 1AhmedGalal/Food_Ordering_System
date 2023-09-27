package userinterfacecomponents.admincomponents;

import datahandlers.DataHandlerFactory;
import datahandlers.usersdatahandler.UserDataHandler;
import datahandlers.usersdatahandler.UserDataHandlerFactory;
import userinterfacecomponents.UserInterfaceComponent;
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter User's Phone : ");
        String phone = scanner.next();

        User user = new NormalUser(phone);

        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();

        userDataHandler.setObject(user);
        userDataHandler.loadAllData();
        userDataHandler.removeObject();
    }
}
