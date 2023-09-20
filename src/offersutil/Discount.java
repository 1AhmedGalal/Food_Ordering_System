package offersutil;

import foodutil.Food;
import users.Restaurant;

class Discount extends Offer
{
    Food food;

    public Discount(Restaurant restaurant, double percentage, Food food)
    {
        super(restaurant, percentage);
        this.food = food;
    }
}
