package datahandlers.admininterface;

import userinterfacecollectors.AdminInterface;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.admincomponentsutil.BanUserComponent;
import userinterfacecomponents.admincomponentsutil.ViewAllRestaurantsComponent;
import userinterfacecomponents.admincomponentsutil.ViewAllUsersComponents;
import userinterfacecomponents.maininterfacecomponents.SignOutComponent;

public class AdminInterfaceDummyDataHandler extends AdminInterfaceDataHandler
{
    AdminInterfaceDummyDataHandler(AdminInterface adminInterface)
    {
        super(adminInterface);
    }

    @Override
    public void saveAllData()
    {
        //nothing to do
    }

    @Override
    public void loadAllData()
    {
        UserInterfaceComponent userInterfaceComponent = new BanUserComponent("Ban user");
        adminInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewAllUsersComponents("View all users");
        adminInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewAllRestaurantsComponent("View all restaurants");
        adminInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new SignOutComponent("Sign out");
        adminInterface.addComponent(userInterfaceComponent);

    }

    @Override
    public void saveObject(Object object)
    {
        adminInterface.addComponent((UserInterfaceComponent) object);
    }

    @Override
    public void removeObject(Object object)
    {
        adminInterface.removeComponent((UserInterfaceComponent) object);
    }

    @Override
    public Object loadFullObject()
    {
        return adminInterface;
    }
}