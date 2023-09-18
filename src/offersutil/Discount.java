package offersutil;

import foodutil.Food;
import usersutil.Restaurant;

class Discount extends Offer
{
    Food food;

    public Discount(Restaurant restaurant, double percentage, Food food)
    {
        super(restaurant, percentage);
        this.food = food;
    }
}
