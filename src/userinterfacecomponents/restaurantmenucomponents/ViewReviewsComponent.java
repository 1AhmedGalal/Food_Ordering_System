package userinterfacecomponents.restaurantmenucomponents;

import datahandlers.DataHandlerException;
import datahandlers.reviews.ReviewDataHandler;
import datahandlers.reviews.ReviewDataHandlerFactory;
import logger.Logger;
import offers.Discount;
import offers.Offer;
import review.RestaurantReview;
import review.Review;
import userinterfacecomponents.UserInterfaceComponent;
import users.User;

import java.util.LinkedList;

public class ViewReviewsComponent extends UserInterfaceComponent {
    private User user;
    public ViewReviewsComponent(String message)
    {
        super(message);
        this.user = null;
    }

    @Override
    public void doWork() throws Exception
    {
        loadUser();
        LinkedList<String> reviews = loadReviews();

        int id = 1;
        for(String review : reviews)
        {
            System.out.println(id + ") " + review);
            id++;
        }
    }

    private void loadUser() throws Exception
    {
        Logger logger = Logger.getInstance();
        user = logger.getUser();
    }

    private LinkedList<String> loadReviews() throws DataHandlerException
    {
        ReviewDataHandlerFactory reviewDataHandlerFactory = new ReviewDataHandlerFactory();
        ReviewDataHandler reviewDataHandler = (ReviewDataHandler) reviewDataHandlerFactory.createDataHandler();

        reviewDataHandler.loadAllData();
        LinkedList<String> reviewIDs = reviewDataHandler.loadReviewIDs(user.getPhone());

        LinkedList<String> reviewDetails = new LinkedList<>();
        for(String reviewID : reviewIDs)
        {
            Review review = new RestaurantReview(reviewID); //type doesn't matter
            reviewDataHandler.setObject(review);
            review = (Review) reviewDataHandler.loadFullObject();

            reviewDetails.add("Restaurant : " + review.getSubjectID()
                              + ", User : " + review.getReviewerID()
                              + ", Rating : " + review.getRating()
                              + "\n Details : " + review.getReviewDetails());
        }

        return reviewDetails;
    }
}
