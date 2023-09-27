package datahandlers.reviews;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;

public class ReviewDataHandlerFactory implements DataHandlerFactory
{
    @Override
    public DataHandler createDataHandler()
    {
        return ReviewFileHandler.getInstance();
    }
}
