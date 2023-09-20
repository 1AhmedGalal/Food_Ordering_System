package datahandlers.userinterfaceutil;

import userinterfacecollectors.UserInterface;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.admincomponentsutil.ViewAllRestaurantsComponent;
import userinterfacecomponents.maininterfacecomponents.SignOutComponent;
import userinterfacecomponents.restaurantmenucomponentutil.CancelOrderComponent;
import userinterfacecomponents.usercompoenentsutil.MakeOrderComponent;
import userinterfacecomponents.restaurantmenucomponentutil.ViewMenuComponent;
import userinterfacecomponents.restaurantmenucomponentutil.ViewOrdersComponent;

public class UserInterfaceDummyDataHandler extends UserInterfaceDataHandler
{
    public UserInterfaceDummyDataHandler(UserInterface userInterface) {
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
