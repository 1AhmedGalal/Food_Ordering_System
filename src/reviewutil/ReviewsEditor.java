package reviewutil;

import datahandlers.DataHandler;
import users.Restaurant;
import users.User;
import java.util.ArrayList;

public abstract class ReviewsEditor
{
    User user;
    ArrayList<Review> reviews;
    DataHandler dataHandler;

    public ReviewsEditor(User user, DataHandler dataHandler)
    {
        this.user = user;
        this.dataHandler = dataHandler;
        this.reviews = new ArrayList<>();
        dataHandler.loadAllData();
    }

    public void addReview(User user, Restaurant restaurant, String header, String details, double rating)
    {
        Review review = new RestaurantReview(user, restaurant, header, details, rating);
        reviews.add(review);
    }

    public void removeReview(Restaurant restaurant) throws Exception
    {
        for(Review review : reviews)
        {
            if(review.getUser().getName().equals(user.getName()) || review.getRestaurant().getName().equals(restaurant.getName()))
            {
                reviews.remove(review);
                return;
            }
        }

        throw new Exception("Review Not Found");

    }

    public void editReviewRating(Restaurant restaurant, double rating) throws Exception
    {
        for(Review review : reviews)
        {
            if(review.getUser().getName().equals(user.getName()) || review.getRestaurant().getName().equals(restaurant.getName()))
            {
                review.setRating(rating);
                return;
            }
        }

        throw new Exception("Review Not Found");

    }

    public void editReviewHeader(Restaurant restaurant, String header) throws Exception
    {
        for(Review review : reviews)
        {
            if(review.getUser().getName().equals(user.getName()) || review.getRestaurant().getName().equals(restaurant.getName()))
            {
                review.setHeader(header);
                return;
            }
        }

        throw new Exception("Review Not Found");
    }

    public void editReviewDetails(Restaurant restaurant, String details) throws Exception
    {
        for(Review review : reviews)
        {
            if(review.getUser().getName().equals(user.getName()) || review.getRestaurant().getName().equals(restaurant.getName()))
            {
                review.setDetails(details);
                return;
            }
        }

        throw new Exception("Review Not Found");

    }

    public String getReview(User user) throws Exception
    {
        for(Review review : reviews)
        {
            if(review.getUser().getName().equals(user.getName()) || review.getRestaurant().getName().equals(user.getName()))
                return review.toString();
        }

        throw new Exception("Review Not Found");
    }



}
