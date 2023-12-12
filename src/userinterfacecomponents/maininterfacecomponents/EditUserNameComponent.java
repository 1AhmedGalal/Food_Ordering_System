package userinterfacecomponents.maininterfacecomponents;

import datahandlers.usersdata.UserDataHandler;
import datahandlers.usersdata.UserDataHandlerFactory;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.User;

import java.util.Scanner;

public class EditUserNameComponent extends UserInterfaceComponent
{
    private User user;

    public EditUserNameComponent(String message)
    {
        super(message);
        this.user = null;
    }

    @Override
    public void doWork() throws Exception
    {
        System.out.println("Name : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        if(name == null)
            throw new Exception("Invalid Name");

        loadUser();
        updateUser(name);
    }

    private void loadUser() throws Exception
    {
        Logger logger = Logger.getInstance();
        user = logger.getUser();
    }

    private void updateUser(String name) throws Exception
    {
        //data handlers saves all changes

        user.setName(name);

        UserDataHandlerFactory userDataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) userDataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();

        userDataHandler.setObject(user);
        userDataHandler.updateObject();
    }
}
