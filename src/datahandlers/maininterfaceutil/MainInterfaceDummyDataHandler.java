package datahandlers.maininterfaceutil;

import userinterfacecollectors.MainInterface;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.maininterfacecomponents.ExitComponent;
import userinterfacecomponents.maininterfacecomponents.RestaurantJoiningComponent;
import userinterfacecomponents.maininterfacecomponents.SignInComponent;
import userinterfacecomponents.maininterfacecomponents.SignUpComponent;

public class MainInterfaceDummyDataHandler extends MainInterfaceDataHandler
{

    public MainInterfaceDummyDataHandler(MainInterface mainInterface) {
        super(mainInterface);
    }

    @Override
    public void saveAllData()
    {

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
