package datahandlers.foods;

import datahandlers.DataHandler;
import datahandlers.DataHandlerFactory;

public class FoodDataHandlerFactory implements DataHandlerFactory
{

    @Override
    public DataHandler createDataHandler()
    {
        return FoodFileHandler.getInstance();
    }

}
