package datahandlers.userinterface;

import datahandlers.DataHandlerException;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.admincomponents.ViewAllRestaurantsComponent;
import userinterfacecomponents.maininterfacecomponents.DeleteAccountComponent;
import userinterfacecomponents.maininterfacecomponents.EditPasswordComponent;
import userinterfacecomponents.maininterfacecomponents.EditUserNameComponent;
import userinterfacecomponents.maininterfacecomponents.SignOutComponent;
import userinterfacecomponents.restaurantmenucomponents.*;
import userinterfacecomponents.usercompoenents.*;

public class UserInterfaceDummyDataHandler extends UserInterfaceDataHandler
{


    private static UserInterfaceDummyDataHandler instance = null;


    public static UserInterfaceDummyDataHandler getInstance()
    {
        if(instance == null)
            instance = new UserInterfaceDummyDataHandler();

        return instance;
    }

    private UserInterfaceDummyDataHandler()
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

        userInterfaceComponent = new ViewOffersComponent("View Coupons");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ViewReviewsComponent("View Reviews");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new MakeOrderComponent("Make Order");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new CancelOrderComponent("Cancel Order");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new AddReviewComponent("Add Review");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new EditReviewComponent("Edit Review");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new RemoveReviewComponent("Remove Review");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new EditUserNameComponent("Change User Name");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new EditPasswordComponent("Change Password");
        userInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new DeleteAccountComponent("Remove Account");
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
