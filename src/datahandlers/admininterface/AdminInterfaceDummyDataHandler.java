package datahandlers.admininterface;

import datahandlers.DataHandlerException;
import userinterfacecollectors.AdminInterface;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.admincomponents.RemoveUserComponent;
import userinterfacecomponents.admincomponents.ViewAllRestaurantsComponent;
import userinterfacecomponents.admincomponents.ViewAllUsersComponents;
import userinterfacecomponents.maininterfacecomponents.SignOutComponent;

public class AdminInterfaceDummyDataHandler extends AdminInterfaceDataHandler
{
    AdminInterfaceDummyDataHandler()
    {
        super();
    }

    @Override
    public void saveAllData()
    {
        //nothing to do
    }

    @Override
    public void loadAllData()
    {
        UserInterfaceComponent userInterfaceComponent = new RemoveUserComponent("Remove user/restaurant");
        adminInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewAllUsersComponents("View all users");
        adminInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewAllRestaurantsComponent("View all restaurants");
        adminInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new SignOutComponent("Sign out");
        adminInterface.addComponent(userInterfaceComponent);

    }

    @Override
    public void saveObject() throws DataHandlerException {

    }

    @Override
    public void removeObject() throws DataHandlerException {

    }

    @Override
    public void updateObject() throws DataHandlerException {

    }

    @Override
    public Object loadFullObject()
    {
        return adminInterface;
    }
}
