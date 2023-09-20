package datahandlers.restaurantinterfaceutil;

import userinterfacecomponentcollectingutil.RestaurantInterface;
import userinterfacecomponentutil.UserInterfaceComponent;
import userinterfacecomponentutil.maininterfaceutil.SignOutComponent;
import userinterfacecomponentutil.restaurantmenucomponentutil.*;

public class RestaurantInterfaceDummyDataHandler extends RestaurantInterfaceDataHandler
{
    public RestaurantInterfaceDummyDataHandler(RestaurantInterface restaurantInterface)
    {
        super(restaurantInterface);
    }

    @Override
    public void saveAllData()
    {

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

    }

    @Override
    public void removeObject(Object object)
    {

    }

    @Override
    public Object loadFullObject()
    {
        return null;
    }
}
