package reviewutil;

import datahandlers.DataHandler;
import datahandlers.DataHandlerException;
import users.User;

public class FoodReviewEditor extends ReviewsEditor
{
    public FoodReviewEditor(User user, DataHandler dataHandler) throws DataHandlerException {
        super(user, dataHandler);
    }
}
