package offersutil;

import usersutil.Restaurant;
import usersutil.User;

class Coupon extends Offer
{
    User user;

    public Coupon(Restaurant restaurant, double percentage, User user)
    {
        super(restaurant, percentage);
        this.user = user;
    }
}
