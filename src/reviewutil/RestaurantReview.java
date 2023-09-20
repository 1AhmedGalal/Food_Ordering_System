package reviewutil;

import users.Restaurant;
import users.User;

class RestaurantReview extends Review
{

    public RestaurantReview(User user, Restaurant restaurant, String header, String details, double rating)
    {
        super(user, restaurant, header, details, rating);
    }


}
