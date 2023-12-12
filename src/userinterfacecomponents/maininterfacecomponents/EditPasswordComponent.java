package userinterfacecomponents.maininterfacecomponents;

import datahandlers.usersdata.UserDataHandler;
import datahandlers.usersdata.UserDataHandlerFactory;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.User;

import java.util.Scanner;

public class EditPasswordComponent extends UserInterfaceComponent
{
    private User user;

    public EditPasswordComponent(String message)
    {
        super(message);
        this.user = null;
    }

    @Override
    public void doWork() throws Exception
    {
        System.out.println("Password : ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if(password == null || password.length() < 8)
            throw new Exception("Invalid Password");

        loadUser();
        updateUser(password);
    }

    private void loadUser() throws Exception
    {
        Logger logger = Logger.getInstance();
        user = logger.getUser();
    }

    private void updateUser(String password) throws Exception
    {
        //data handlers saves all changes

        user.setPassword(password);

        UserDataHandlerFactory userDataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) userDataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();

        userDataHandler.setObject(user);
        userDataHandler.updateObject();
    }
}
