package reviewutil;

import users.Restaurant;
import users.User;

abstract class Review
{
    User user;
    Restaurant restaurant;
    String header;
    String details;
    double rating;

    public Review(User user, Restaurant restaurant, String header, String details, double rating)
    {
        this.user = user;
        this.restaurant = restaurant;
        this.header = header;
        this.details = details;
        this.rating = rating;
    }

    public String getHeader()
    {
        if(header == null)
            return "(Empty Header)";

        return header;
    }

    public void setHeader(String header)
    {
        this.header = header;
    }

    public String getDetails()
    {
        if(details == null)
            return  "(Empty Details)";

        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public double getRating()
    {
        return rating;
    }

    public void setRating(double rating)
    {
        this.rating = rating;
    }

    public User getUser()
    {
        return user;
    }

    public Restaurant getRestaurant()
    {
        return restaurant;
    }

    @Override
    public String toString()
    {
        return "Review{" +
                "user: " + user.getName() +
                ", restaurant : " + restaurant +
                ", header : '" + getHeader() + '\'' +
                ", details : '" + getDetails() + '\'' +
                ", rating : " + rating +
                '}';
    }
}
