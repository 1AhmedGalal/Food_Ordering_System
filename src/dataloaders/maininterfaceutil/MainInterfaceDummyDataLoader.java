package dataloaders.maininterfaceutil;

import userinterfacecomponentcollectingutil.MainInterface;
import userinterfacecomponentutil.UserInterfaceComponent;
import userinterfacecomponentutil.maininterfaceutil.ExitComponent;
import userinterfacecomponentutil.maininterfaceutil.RestaurantJoiningComponent;
import userinterfacecomponentutil.maininterfaceutil.SignInComponent;
import userinterfacecomponentutil.maininterfaceutil.SignUpComponent;

public class MainInterfaceDummyDataLoader extends MainInterfaceDataLoader
{

    public MainInterfaceDummyDataLoader(MainInterface mainInterface) {
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
