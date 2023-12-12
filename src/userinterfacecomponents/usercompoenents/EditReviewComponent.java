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

public class EditReviewComponent extends UserInterfaceComponent
{
    private User user;

    private ReviewDataHandler reviewDataHandler;
    public EditReviewComponent(String message)
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
            throw new Exception("Invalid Data");

        System.out.println("Enter 1 to edit the rating and 2 to edit the review details : ");
        int choice = scanner.nextInt();

        switch (choice)
        {
            case 1:
                System.out.println("Enter Rating (1-5) : ");
                double rating = scanner.nextDouble();
                updateReview(restaurantPhone, rating);
                break;

            case 2:
                scanner.skip("\n");
                System.out.println("Enter Details (enter 1 to skip) : ");
                String details = "";
                details += scanner.nextLine();

                if(details.equals("1"))
                    details = "Empty";

                updateReview(restaurantPhone, details);
                break;

            default:
                throw new Exception("Invalid Choice");
        }
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

    private void updateReview(String restaurantPhone, double rating) throws Exception
    {
        if(!isValidRating(rating))
            throw new Exception("Not a valid rating");

        //load the original review
        RestaurantReview restaurantReview = new RestaurantReview(user.getPhone(), restaurantPhone);
        reviewDataHandler.setObject(restaurantReview);
        restaurantReview = (RestaurantReview) reviewDataHandler.loadFullObject();

        //change the review and update it
        restaurantReview.setRating(rating);
        reviewDataHandler.setObject(restaurantReview);
        reviewDataHandler.updateObject();
    }

    private void updateReview(String restaurantPhone, String details) throws Exception
    {
        //load the original review
        RestaurantReview restaurantReview = new RestaurantReview(user.getPhone(), restaurantPhone);
        reviewDataHandler.setObject(restaurantReview);
        restaurantReview = (RestaurantReview) reviewDataHandler.loadFullObject();

        //change the review and update it
        restaurantReview.setReviewDetails(details);
        reviewDataHandler.setObject(restaurantReview);
        reviewDataHandler.updateObject();
    }
}
