package review;

public abstract class Review
{
    protected String reviewID;

    protected String reviewerID;

    protected String subjectID;

    protected String reviewDetails;

    protected double rating;

    public Review(String reviewID)
    {
        this.reviewID = reviewID;
    }

    public Review(String reviewerID, String subjectID, String reviewDetails, double rating)
    {
        this.reviewerID = reviewerID;
        this.subjectID = subjectID;
        this.reviewDetails = reviewDetails;
        this.rating = rating;
        this.reviewID = reviewerID + subjectID;
    }

    public String getReviewID()
    {
        return reviewID;
    }

    public String getReviewerID()
    {
        return reviewerID;
    }

    public String getSubjectID()
    {
        return subjectID;
    }

    public String getReviewDetails()
    {
        return reviewDetails;
    }

    public double getRating()
    {
        return rating;
    }

    public void setReviewDetails(String reviewDetails)
    {
        this.reviewDetails = reviewDetails;
    }

    public void setRating(double rating)
    {
        this.rating = rating;
    }
}
