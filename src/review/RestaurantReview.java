package review;

public class RestaurantReview extends Review
{

    public RestaurantReview(String reviewID)
    {
        super(reviewID);
    }

    public RestaurantReview(String reviewerID, String subjectID)
    {
        super(reviewerID, subjectID);
    }

    public RestaurantReview(String reviewerID, String subjectID, String reviewDetails, double rating)
    {
        super(reviewerID, subjectID, reviewDetails, rating);
    }
}
