package datahandlers.reviews;

import datahandlers.DataHandler;
import datahandlers.DataHandlerException;
import review.Review;

import java.util.Hashtable;
import java.util.LinkedList;

public abstract class ReviewDataHandler implements DataHandler
{
    protected boolean allDataLoaded;

    protected Review review;

    protected Hashtable<String, LinkedList<String>> reviewers; // key: userPhone, value: reviewID

    protected Hashtable<String, LinkedList<String>> subjects; // key: restaurantPHone, value: reviewID

    protected Hashtable<String, Review> reviews; // key: reviewID, value: review

    ReviewDataHandler()
    {
        review = null;
        reviewers = new Hashtable<>();
        subjects = new Hashtable<>();
        reviews = new Hashtable<>();
        allDataLoaded = false;
    }

    @Override
    public void setObject(Object object)
    {
        this.review = (Review) object;
    }

    @Override
    public void alertUpdate()
    {
        reviewers.clear();
        subjects.clear();
        reviews.clear();
        allDataLoaded = false;
    }

    public LinkedList<String> loadReviewIDs(String id) throws DataHandlerException
    {
        if(reviewers.containsKey(id))
        {
            return reviewers.get(id);
        }
        else if(subjects.containsKey(id))
        {
            return subjects.get(id);
        }
        else
        {
            throw new DataHandlerException("No Data Found");
        }
    }

    protected void addReview(String ownerID, String reviewID, Hashtable<String, LinkedList<String>> container)
    {
        //when the container is empty make it first
        if(!container.containsKey(ownerID) || container.get(ownerID).isEmpty())
            container.put(ownerID, new LinkedList<String>());

        container.get(ownerID).add(reviewID);
    }

    protected void removeReview(String ownerID, String reviewID, Hashtable<String, LinkedList<String>> container) throws DataHandlerException
    {
        //when the container is empty make it first
        if(!container.containsKey(ownerID) || container.get(ownerID).isEmpty())
            throw new DataHandlerException("Data not found");

        container.get(ownerID).remove(reviewID);
    }
}
