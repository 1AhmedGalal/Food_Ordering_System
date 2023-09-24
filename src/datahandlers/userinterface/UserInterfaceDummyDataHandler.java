package datahandlers.userinterface;

import datahandlers.DataHandlerException;
import userinterfacecollectors.UserInterface;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.admincomponents.ViewAllRestaurantsComponent;
import userinterfacecomponents.maininterfacecomponents.SignOutComponent;
import userinterfacecomponents.restaurantmenucomponents.CancelOrderComponent;
import userinterfacecomponents.usercompoenentsutil.MakeOrderComponent;
import userinterfacecomponents.restaurantmenucomponents.ViewMenuComponent;
import userinterfacecomponents.restaurantmenucomponents.ViewOrdersComponent;

public class UserInterfaceDummyDataHandler extends UserInterfaceDataHandler
{


    UserInterfaceDummyDataHandler()
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
    public void alertUpdate() {

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
        return userInterface;
    }
}
