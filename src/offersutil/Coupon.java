package offersutil;

import users.Restaurant;
import users.User;

class Coupon extends Offer
{
    User user;

    public Coupon(Restaurant restaurant, double percentage, User user)
    {
        super(restaurant, percentage);
        this.user = user;
    }
}
