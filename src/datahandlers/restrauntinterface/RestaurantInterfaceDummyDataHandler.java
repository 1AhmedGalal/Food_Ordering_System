package datahandlers.restrauntinterface;

import userinterfacecollectors.RestaurantInterface;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.maininterfacecomponents.SignOutComponent;
import userinterfacecomponents.restaurantmenucomponentutil.*;

public class RestaurantInterfaceDummyDataHandler extends RestaurantInterfaceDataHandler
{
    RestaurantInterfaceDummyDataHandler(RestaurantInterface restaurantInterface)
    {
        super(restaurantInterface);
    }

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

        userInterfaceComponent = new SignOutComponent("Remove Account");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new SignOutComponent("Sign Out");
        restaurantInterface.addComponent(userInterfaceComponent);
    }

    @Override
    public void saveObject(Object object)
    {
        restaurantInterface.addComponent((UserInterfaceComponent) object);
    }

    @Override
    public void removeObject(Object object)
    {
        restaurantInterface.removeComponent((UserInterfaceComponent) object);
    }

    @Override
    public Object loadFullObject()
    {
        return restaurantInterface;
    }
}
