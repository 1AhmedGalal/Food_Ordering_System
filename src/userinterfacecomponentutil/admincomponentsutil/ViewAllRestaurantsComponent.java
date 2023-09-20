package userinterfacecomponentutil.admincomponentsutil;

import dataloaders.user.UserDataDummyLoader;
import dataloaders.user.UserDataLoader;
import dataloaders.user.UserType;
import logger.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
import users.User;

import java.util.ArrayList;

public class ViewAllRestaurantsComponent extends UserInterfaceComponent
{
    public ViewAllRestaurantsComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Logger logger = Logger.getInstance();
        User user = logger.getUser();

        UserDataLoader userDataLoader = new UserDataDummyLoader(user);
        userDataLoader.loadAllData();
        ArrayList<String> usersData = userDataLoader.getAllUsersData(UserType.RESTAURANT);

        for(String userData : usersData)
            System.out.println(userData);
    }
}
