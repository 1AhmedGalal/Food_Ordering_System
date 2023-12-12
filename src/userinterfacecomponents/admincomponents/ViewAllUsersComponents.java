package userinterfacecomponents.admincomponents;

import datahandlers.DataHandlerFactory;
import datahandlers.usersdata.UserDataHandler;
import datahandlers.usersdata.UserDataHandlerFactory;
import datahandlers.usersdata.UserType;
import userinterfacecomponents.UserInterfaceComponent;

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
        // 1) get the data handler ready
        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();

        // 2) get the users data
        ArrayList<String> usersData = userDataHandler.getAllUsersData(UserType.NORMAL);
        for(String userData : usersData)
            System.out.println(userData);
    }
}
