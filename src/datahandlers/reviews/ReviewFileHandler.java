package datahandlers.reviews;

import datahandlers.DataHandlerException;
import datahandlers.userinterface.UserInterfaceDummyDataHandler;
import review.RestaurantReview;
import review.Review;

import java.io.*;
import java.util.Set;

public class ReviewFileHandler extends ReviewDataHandler
{
    private String reviewID;
    private String reviewerID;
    private String subjectID;
    private String reviewDetails;
    private double rating;

    private static ReviewFileHandler instance = null;


    public static ReviewFileHandler getInstance()
    {
        if(instance == null)
            instance = new ReviewFileHandler();

        return instance;
    }
    private ReviewFileHandler()
    {
        super();
        reviewID = null;
        reviewerID = null;
        subjectID = null;
        reviewDetails = null;
        rating = 0.0;
    }

    @Override
    public void saveObject() throws DataHandlerException
    {
        String reviewID = review.getReviewID();
        String reviewerID = review.getReviewerID();
        String subjectID = review.getSubjectID();

        reviews.put(reviewID, review);
        addReview(reviewerID, reviewID, reviewers);
        addReview(subjectID, reviewID, subjects);

        saveAllData();
    }

    @Override
    public void removeObject() throws DataHandlerException
    {
        String reviewID = review.getReviewID();
        String reviewerID = review.getReviewerID();
        String subjectID = review.getSubjectID();

        if(!reviews.containsKey(reviewID))
            throw new DataHandlerException("Review Not Found");

        reviews.remove(reviewID);
        removeReview(reviewerID, reviewID, reviewers);
        removeReview(subjectID, reviewID, subjects);

        saveAllData();
    }

    @Override
    public void updateObject() throws DataHandlerException
    {
        String reviewID = review.getReviewID();

        if(!reviews.containsKey(reviewID))
            throw new DataHandlerException("Review Not Found");

        removeObject();
        saveObject();
    }

    @Override
    public Object loadFullObject() throws DataHandlerException
    {
        String reviewID = review.getReviewID();

        if(!reviews.containsKey(reviewID))
            throw new DataHandlerException("Review Not Found");

        return reviews.get(reviewID);
    }

    @Override
    public void saveAllData() throws DataHandlerException
    {
        if(!allDataLoaded) // this prevents clearing the file and losing all data
            loadAllData();

        try
        {
            clearFile(); //this is done to avoid duplicates

            BufferedWriter writer = new BufferedWriter(new FileWriter("reviews.txt"));
            writer.write("=");

            Set<String> setOfIDs = reviews.keySet();
            for(String reviewID : setOfIDs)
            {
                Review review = reviews.get(reviewID);

                writer.write("\n" + review.getReviewID());
                writer.write("\n" + review.getReviewerID());
                writer.write("\n" + review.getSubjectID());
                writer.write("\n" + review.getReviewDetails());
                writer.write("\n" + Double.toString(review.getRating()));

                writer.write("\n" + "=");
            }

            writer.close();
        }
        catch (IOException e)
        {
            throw new DataHandlerException(e.getMessage());
        }

        allDataLoaded = false;
    }

    @Override
    public void loadAllData() throws DataHandlerException
    {
        if(allDataLoaded)
            return;

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("reviews.txt"));
            String line;

            Review review = null;

            int cnt = 0;

            while((line = reader.readLine()) != null)
            {
                if(line.equals("="))
                {
                    if(cnt != 0) //makes sure that this "=" is not the beginning of the file but the end of a food
                    {
                        review = new RestaurantReview(reviewerID, subjectID, reviewDetails, rating);

                        reviews.put(reviewID, review);
                        addReview(reviewerID, reviewID, reviewers);
                        addReview(subjectID, reviewID, subjects);
                    }

                    cnt = 0;
                    continue;
                }

                switch (cnt)
                {
                    case 0:
                        reviewID = line;
                        break;

                    case 1:
                        reviewerID = line;
                        break;

                    case 2:
                        subjectID = line;
                        break;

                    case 3:
                        reviewDetails = line;
                        break;

                    case 4:
                        rating = Double.parseDouble(line);
                        break;

                    default:
                        break;
                }

                cnt++;
            }

            reader.close();
        }
        catch (Exception e)
        {
            throw new DataHandlerException(e.getMessage());
        }

        allDataLoaded = true;
    }

    private void clearFile() throws DataHandlerException
    {
        try
        {
            FileWriter fileWriter = new FileWriter("reviews.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter, false);
            printWriter.flush();
            printWriter.close();
            fileWriter.close();
        }
        catch (Exception e)
        {
            throw new DataHandlerException(e.getMessage());
        }
    }
}
