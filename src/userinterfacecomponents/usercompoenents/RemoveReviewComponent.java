package userinterfacecomponents.usercompoenents;

import datahandlers.DataHandlerException;
import datahandlers.reviews.ReviewDataHandler;
import datahandlers.reviews.ReviewDataHandlerFactory;
import datahandlers.usersdata.UserDataHandler;
import datahandlers.usersdata.UserDataHandlerFactory;
import logger.Logger;
import review.RestaurantReview;
import userinterfacecomponents.UserInterfaceComponent;
import users.NormalUser;
import users.OnlineRestaurant;
import users.Restaurant;
import users.User;

import java.util.Scanner;

public class RemoveReviewComponent extends UserInterfaceComponent
{
    private User user;

    private ReviewDataHandler reviewDataHandler;

    public RemoveReviewComponent(String message)
    {
        super(message);
        this.user = null;
        this.reviewDataHandler = null;
    }

    @Override
    public void doWork() throws Exception
    {
        loadUser();
        loadReviews();

        if(!(user instanceof NormalUser))
            throw new Exception("Only Customers Are Allowed To Add Reviews");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Restaurant Phone : ");
        String restaurantPhone = scanner.next();

        if(!isValidRestaurant(restaurantPhone) || !reviewAlreadyExists(restaurantPhone))
            throw new Exception("Invalid Operation");

        removeReview(restaurantPhone);
    }

    private void loadUser() throws Exception
    {
        Logger logger = Logger.getInstance();
        user = logger.getUser();
    }

    private void loadReviews() throws DataHandlerException
    {
        ReviewDataHandlerFactory reviewDataHandlerFactory = new ReviewDataHandlerFactory();
        reviewDataHandler = (ReviewDataHandler) reviewDataHandlerFactory.createDataHandler();
        reviewDataHandler.loadAllData();
    }

    private boolean isValidRestaurant(String restaurantPhone) throws Exception
    {
        UserDataHandlerFactory userDataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) userDataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();

        //restaurant type doesn't matter as it will be corrected by the data handler
        OnlineRestaurant restaurant = new OnlineRestaurant(restaurantPhone);
        userDataHandler.setObject(restaurant);
        User tempUser = (User) userDataHandler.loadFullObject();

        //the restaurant must exist and the review must be for a restaurant not any other type of user
        return userDataHandler.userPhoneExists() && tempUser instanceof Restaurant;
    }

    private boolean reviewAlreadyExists(String restaurantPhone) throws DataHandlerException
    {
        RestaurantReview restaurantReview = new RestaurantReview(user.getPhone(), restaurantPhone);
        reviewDataHandler.setObject(restaurantReview);

        //if loadFullObject() throws an exception then that means the object doesn't exist
        try
        {
            reviewDataHandler.loadFullObject();
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }

    private void removeReview(String restaurantPhone) throws DataHandlerException
    {
        RestaurantReview restaurantReview = new RestaurantReview(user.getPhone(), restaurantPhone);
        reviewDataHandler.setObject(restaurantReview);
        reviewDataHandler.removeObject();
    }
}
