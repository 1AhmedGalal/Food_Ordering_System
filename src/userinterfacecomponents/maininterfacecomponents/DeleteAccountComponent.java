package userinterfacecomponents.maininterfacecomponents;

import datahandlers.DataHandlerFactory;
import datahandlers.usersdatahandler.UserDataHandler;
import datahandlers.usersdatahandler.UserDataHandlerFactory;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.User;

public class DeleteAccountComponent extends UserInterfaceComponent
{
    private User user;

    public DeleteAccountComponent(String message)
    {
        super(message);
        this.user = null;
    }

    public DeleteAccountComponent(String message, User user)
    {
        super(message);
        this.user = user;
    }

    @Override
    public void doWork() throws Exception
    {

        Logger logger = Logger.getInstance();
        User user = logger.getUser();
        logger.signOut();

        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();

        userDataHandler.loadAllData();
        userDataHandler.setObject(user);
        userDataHandler.removeObject();

        //remove orders
        //remove food
        //remove offers and coupons
        //remove menu
    }
}
