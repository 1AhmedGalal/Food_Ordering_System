package userinterfacecomponents.usercompoenents;

import datahandlers.DataHandlerException;
import datahandlers.reviews.ReviewDataHandler;
import datahandlers.reviews.ReviewDataHandlerFactory;
import datahandlers.usersdata.UserDataHandler;
import datahandlers.usersdata.UserDataHandlerFactory;
import logger.Logger;
import review.RestaurantReview;
import userinterfacecomponents.UserInterfaceComponent;
import users.*;

import java.security.spec.ECField;
import java.util.Scanner;


public class AddReviewComponent extends UserInterfaceComponent
{
    private User user;

    private ReviewDataHandler reviewDataHandler;
    public AddReviewComponent(String message)
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

        System.out.println("Enter Rating (1-5) : ");
        double rating = scanner.nextDouble();

        scanner.skip("\n");
        System.out.println("Enter Details (enter 1 to skip) : ");
        String details = "";
        details += scanner.nextLine();

        if(details.equals("1"))
            details = "Empty";

        if(!isValidRating(rating) || !isValidRestaurant(restaurantPhone))
            throw new Exception("Invalid Data");
        else if(reviewAlreadyExists(restaurantPhone))
            throw new Exception("You have already made a review about the restaurant");

        addReview(restaurantPhone, rating, details);
    }

    private void loadUser() throws Exception
    {
        Logger logger = Logger.getInstance();
        user = logger.getUser();
    }

    private boolean isValidRestaurant(String restaurantPhone) throws Exception
    {
        UserDataHandlerFactory userDataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) userDataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();

        //restaurant type doesn't matter as it will be creected by the data handler
        OnlineRestaurant restaurant = new OnlineRestaurant(restaurantPhone);
        userDataHandler.setObject(restaurant);
        User tempUser = (User) userDataHandler.loadFullObject();

        //the restaurant must exist and the review must be for a restaurant not any other type of user
        return userDataHandler.userPhoneExists() && tempUser instanceof Restaurant;
    }

    private boolean isValidRating(double rating)
    {
        return rating >= 1.0 && rating <= 5.0;
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

    private void addReview(String restaurantPhone, double rating, String details) throws DataHandlerException
    {
        RestaurantReview restaurantReview = new RestaurantReview(user.getPhone(), restaurantPhone, details, rating);
        reviewDataHandler.setObject(restaurantReview);
        reviewDataHandler.saveObject();
    }

    private void loadReviews() throws DataHandlerException
    {
        ReviewDataHandlerFactory reviewDataHandlerFactory = new ReviewDataHandlerFactory();
        reviewDataHandler = (ReviewDataHandler) reviewDataHandlerFactory.createDataHandler();
        reviewDataHandler.loadAllData();
    }
}
