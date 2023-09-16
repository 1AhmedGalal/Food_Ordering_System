package userinterfacecomponentutil.admincomponentsutil;

import datasavingutil.userutil.UserDataDummyLoader;
import datasavingutil.userutil.UserDataLoader;
import datasavingutil.userutil.UserType;
import loggingutil.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;
import usersutil.User;

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
