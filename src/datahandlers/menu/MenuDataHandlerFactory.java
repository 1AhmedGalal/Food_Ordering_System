package datahandlers.menu;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;

public class MenuDataHandlerFactory implements DataHandlerFactory
{
    @Override
    public DataHandler createDataHandler()
    {
        return MenuFileHandler.getInstance();
    }
}
