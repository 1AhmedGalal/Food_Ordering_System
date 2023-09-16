package datasavingutil.userinterfaceutil;

import userinterfacecomponentcollectingutil.UserInterface;
import userinterfacecomponentutil.UserInterfaceComponent;
import userinterfacecomponentutil.admincomponentsutil.ViewAllRestaurantsComponent;
import userinterfacecomponentutil.maininterfaceutil.SignOutComponent;
import userinterfacecomponentutil.restaurantmenucomponentutil.CancelOrderComponent;
import userinterfacecomponentutil.usercompoenentsutil.MakeOrderComponent;
import userinterfacecomponentutil.restaurantmenucomponentutil.ViewMenuComponent;
import userinterfacecomponentutil.restaurantmenucomponentutil.ViewOrdersComponent;

public class UserInterfaceDummyDataLoader extends UserInterfaceDataLoader
{
    public UserInterfaceDummyDataLoader(UserInterface userInterface) {
        super(userInterface);
    }

    @Override
    public void saveAllData() {

    }

    @Override
    public void loadAllData() {

        UserInterfaceComponent userInterfaceComponent = new ViewAllRestaurantsComponent("View Restaurants");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewMenuComponent("View Menu");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewOrdersComponent("View Orders");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new MakeOrderComponent("Make Order");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new CancelOrderComponent("Cancel Order");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new SignOutComponent("Sign out");
        userInterface.addComponent(userInterfaceComponent);
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
