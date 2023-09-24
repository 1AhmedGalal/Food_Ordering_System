package datahandlers.restrauntinterface;

import datahandlers.DataHandlerException;
import userinterfacecollectors.RestaurantInterface;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.maininterfacecomponents.DeleteAccountComponent;
import userinterfacecomponents.maininterfacecomponents.SignOutComponent;
import userinterfacecomponents.restaurantmenucomponents.*;

public class RestaurantInterfaceDummyDataHandler extends RestaurantInterfaceDataHandler
{

    @Override
    public void saveAllData()
    {
        //nothing to save
    }

    @Override
    public void loadAllData()
    {
        UserInterfaceComponent userInterfaceComponent = new ViewMenuComponent("View menu");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new AddMenuItemComponent("Add menu item");
        restaurantInterface.addComponent(userInterfaceComponent);


        userInterfaceComponent = new RemoveMenuItemComponent("Remove menu item");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewOrdersComponent("View orders");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ConfirmOrderComponent("Confirm order");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new CancelOrderComponent("Cancel order");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewSitesComponent("View Sites");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new AddSiteComponent("Add Sites");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new RemoveSitesComponent("Remove Sites");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new TransformRestaurantComponent("Change Restaurant Type");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new DeleteAccountComponent("Remove Account");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new SignOutComponent("Sign Out");
        restaurantInterface.addComponent(userInterfaceComponent);
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
        return restaurantInterface;
    }
}
