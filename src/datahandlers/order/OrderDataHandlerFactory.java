package datahandlers.order;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;

public class OrderDataHandlerFactory implements DataHandlerFactory
{
    @Override
    public DataHandler createDataHandler()
    {
        return OrderFileHandler.getInstance();
    }
}
