package offersutil;

import users.Restaurant;

abstract class Offer
{
    Restaurant restaurant;
    double percentage;

    public Offer(Restaurant restaurant, double percentage)
    {
        this.restaurant = restaurant;
        this.percentage = percentage;
    }

    public Restaurant getRestaurant()
    {
        return restaurant;
    }

    public double getPercentage()
    {
        return percentage;
    }
}
