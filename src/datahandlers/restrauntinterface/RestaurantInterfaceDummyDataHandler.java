package datahandlers.restrauntinterface;

import datahandlers.DataHandlerException;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.maininterfacecomponents.DeleteAccountComponent;
import userinterfacecomponents.maininterfacecomponents.EditPasswordComponent;
import userinterfacecomponents.maininterfacecomponents.EditUserNameComponent;
import userinterfacecomponents.maininterfacecomponents.SignOutComponent;
import userinterfacecomponents.restaurantmenucomponents.*;
import userinterfacecomponents.restaurantmenucomponents.ViewOffersComponent;

public class RestaurantInterfaceDummyDataHandler extends RestaurantInterfaceDataHandler
{

    private static RestaurantInterfaceDummyDataHandler instance = null;


    public static RestaurantInterfaceDummyDataHandler getInstance()
    {
        if(instance == null)
            instance = new RestaurantInterfaceDummyDataHandler();

        return instance;
    }
    private RestaurantInterfaceDummyDataHandler()
    {
        super();
    }

    @Override
    public void saveAllData()
    {
        //nothing to save
    }

    @Override
    public void loadAllData()
    {
        UserInterfaceComponent userInterfaceComponent = new ViewReviewsComponent("View reviews");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewMenuComponent("View menu");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new AddMenuItemComponent("Add menu item");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new EditMenuItemComponent("Change menu item");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new RemoveMenuItemComponent("Remove menu item");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewOrdersComponent("View orders");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ConfirmOrderComponent("Confirm order");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new CancelOrderComponent("Cancel order");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewOffersComponent("View Offers");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new AddOfferComponent("Add Offers");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new UpdateOfferComponent("Change Offers");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new RemoveOfferComponent("Remove Offers");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewSitesComponent("View Sites");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new AddSiteComponent("Add Sites");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new RemoveSitesComponent("Remove Sites");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new TransformRestaurantComponent("Change Restaurant Type");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new EditUserNameComponent("Change User Name");
        restaurantInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new EditPasswordComponent("Change Password");
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
