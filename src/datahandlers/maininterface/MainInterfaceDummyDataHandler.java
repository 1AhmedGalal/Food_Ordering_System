package datahandlers.maininterface;

import datahandlers.DataHandlerException;
import datahandlers.menu.MenuFileHandler;
import userinterfacecollectors.MainInterface;
import userinterfacecomponents.UserInterfaceComponent;
import userinterfacecomponents.maininterfacecomponents.ExitComponent;
import userinterfacecomponents.maininterfacecomponents.RestaurantJoiningComponent;
import userinterfacecomponents.maininterfacecomponents.SignInComponent;
import userinterfacecomponents.maininterfacecomponents.SignUpComponent;

public class MainInterfaceDummyDataHandler extends MainInterfaceDataHandler
{


    private static MainInterfaceDummyDataHandler instance = null;


    public static MainInterfaceDummyDataHandler getInstance()
    {
        if(instance == null)
            instance = new MainInterfaceDummyDataHandler();

        return instance;
    }

    private MainInterfaceDummyDataHandler() {
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
        return mainInterface;
    }

}
