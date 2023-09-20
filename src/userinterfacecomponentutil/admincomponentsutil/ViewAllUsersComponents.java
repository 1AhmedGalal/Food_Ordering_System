package userinterfacecomponentutil.admincomponentsutil;

import dataloaders.user.UserDataDummyLoader;
import dataloaders.user.UserDataLoader;
import dataloaders.user.UserType;
import logger.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
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

        UserDataLoader userDataLoader = new UserDataDummyLoader(user);
        userDataLoader.loadAllData();
        ArrayList<String> usersData = userDataLoader.getAllUsersData(UserType.NORMAL);

        for(String userData : usersData)
            System.out.println(userData);
    }
}
