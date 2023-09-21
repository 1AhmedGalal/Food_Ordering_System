package userinterfacecomponents.admincomponentsutil;

import datahandlers.DataHandlerFactory;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserDataHandlerFactory;
import datahandlers.users.UserType;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.User;

import java.util.ArrayList;

public class ViewAllUsersComponents extends UserInterfaceComponent
{
    public ViewAllUsersComponents(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance(null);
        User user = logger.getUser();

        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory(user);
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();

        userDataHandler.loadAllData();
        ArrayList<String> usersData = userDataHandler.getAllUsersData(UserType.NORMAL);

        for(String userData : usersData)
            System.out.println(userData);
    }
}
