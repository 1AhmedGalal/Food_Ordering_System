package userinterfacecomponents.admincomponents;

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

        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();

        ArrayList<String> usersData = userDataHandler.getAllUsersData(UserType.NORMAL);
        for(String userData : usersData)
            System.out.println(userData);
    }
}
