package datahandlers.offers;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;
import datahandlers.order.OrderFileHandler;

public class OfferDataHandlerFactory implements DataHandlerFactory
{
    @Override
    public DataHandler createDataHandler()
    {
        return OfferFileHandler.getInstance();
    }
}
