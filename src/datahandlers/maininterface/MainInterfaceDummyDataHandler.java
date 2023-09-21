package datahandlers.maininterface;

import userinterfacecollectors.MainInterface;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.maininterfacecomponents.ExitComponent;
import userinterfacecomponents.maininterfacecomponents.RestaurantJoiningComponent;
import userinterfacecomponents.maininterfacecomponents.SignInComponent;
import userinterfacecomponents.maininterfacecomponents.SignUpComponent;

public class MainInterfaceDummyDataHandler extends MainInterfaceDataHandler
{

    MainInterfaceDummyDataHandler(MainInterface mainInterface) {
        super(mainInterface);
    }

    @Override
    public void saveAllData()
    {
        //nothing to save
    }

    @Override
    public void loadAllData()
    {

        UserInterfaceComponent userInterfaceComponent = new SignInComponent("Sign in");
        mainInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new SignUpComponent("Sign up");
        mainInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new RestaurantJoiningComponent("Join As Restaurant");
        mainInterface.addComponent(userInterfaceComponent);

        userInterfaceComponent = new ExitComponent("Exit");
        mainInterface.addComponent(userInterfaceComponent);
    }

    @Override
    public void saveObject(Object object)
    {
        mainInterface.addComponent((UserInterfaceComponent) object);
    }

    @Override
    public void removeObject(Object object)
    {
        mainInterface.removeComponent((UserInterfaceComponent) object);
    }

    @Override
    public Object loadFullObject()
    {
        return mainInterface;
    }

}
