package datahandlers.admininterfaceutil;

import userinterfacecomponentcollectingutil.AdminInterface;
import userinterfacecomponentutil.UserInterfaceComponent;
import userinterfacecomponentutil.admincomponentsutil.BanUserComponent;
import userinterfacecomponentutil.admincomponentsutil.ViewAllRestaurantsComponent;
import userinterfacecomponentutil.admincomponentsutil.ViewAllUsersComponents;
import userinterfacecomponentutil.maininterfaceutil.SignOutComponent;

public class AdminInterfaceDummyDataHandler extends AdminInterfaceDataHandler
{
    public AdminInterfaceDummyDataHandler(AdminInterface adminInterface) {
        super(adminInterface);
    }

    @Override
    public void saveAllData() {

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
    public void saveObject(Object object) {

    }

    @Override
    public void removeObject(Object object) {

    }

    @Override
    public Object loadFullObject() {
        return null;
    }
}
