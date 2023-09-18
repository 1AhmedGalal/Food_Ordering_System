package reviewutil;

import usersutil.Restaurant;
import usersutil.User;

class RestaurantReview extends Review
{

    public RestaurantReview(User user, Restaurant restaurant, String header, String details, double rating)
    {
        super(user, restaurant, header, details, rating);
    }


}
