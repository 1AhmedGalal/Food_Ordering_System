package userinterfacecomponents.maininterfacecomponents;

import datahandlers.DataHandlerException;
import datahandlers.DataHandlerFactory;
import datahandlers.foods.FoodDataHandler;
import datahandlers.foods.FoodDataHandlerFactory;
import datahandlers.menu.MenuDataHandler;
import datahandlers.menu.MenuDataHandlerFactory;
import datahandlers.offers.OfferDataHandler;
import datahandlers.offers.OfferDataHandlerFactory;
import datahandlers.order.OrderDataHandler;
import datahandlers.order.OrderDataHandlerFactory;
import datahandlers.reviews.ReviewDataHandler;
import datahandlers.reviews.ReviewDataHandlerFactory;
import datahandlers.usersdata.UserDataHandler;
import datahandlers.usersdata.UserDataHandlerFactory;
import foods.Food;
import foods.MainDish;
import logger.Logger;
import menu.Menu;
import menu.RestaurantMenu;
import offers.Discount;
import offers.Offer;
import orders.FoodOrder;
import orders.Order;
import review.RestaurantReview;
import review.Review;
import userinterfacecomponents.UserInterfaceComponent;
import users.Admin;
import users.NormalUser;
import users.Restaurant;
import users.User;

import java.util.ArrayList;
import java.util.LinkedList;

public class DeleteAccountComponent extends UserInterfaceComponent
{
    private User user;

    public DeleteAccountComponent(String message)
    {
        super(message);
        this.user = null;
    }

    public DeleteAccountComponent(String message, User user)
    {
        super(message);
        this.user = user;
    }

    @Override
    public void doWork() throws Exception
    {
        if(user == null)
        {
            Logger logger = Logger.getInstance();
            user = logger.getUser();
            logger.signOut();
        }

        if(user instanceof Admin)
            throw new Exception("Cannot Remove An Admin!!");

        // delete the user and all the related data
        deleteUser();
        deleteOrders();
        deleteMenu();
        deleteOffers();
        deleteReviews();
    }

    private void deleteUser() throws DataHandlerException
    {
        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
        userDataHandler.loadAllData();

        userDataHandler.setObject(user);
        userDataHandler.removeObject();
    }
    private void deleteOrders()
    {
        //try, catch block is used here because a user might have not made any orders
        //so no need to throw on exception
        try
        {
            OrderDataHandlerFactory orderDataHandlerFactory = new OrderDataHandlerFactory();
            OrderDataHandler orderDataHandler = (OrderDataHandler) orderDataHandlerFactory.createDataHandler();
            orderDataHandler.loadAllData();

            LinkedList<String> orderIDs = orderDataHandler.loadOrdersIDs(user.getPhone());
            for(String orderID : orderIDs)
            {
                Order order = new FoodOrder(orderID);
                orderDataHandler.setObject(order);
                order = (Order) orderDataHandler.loadFullObject();

                orderDataHandler.setObject(order);
                orderDataHandler.removeObject();
            }
        }
        catch (Exception e)
        {
            return;
        }
    }

    private void deleteFood(String foodID)
    {

        //try, catch block is used here because a user might have not made any food items
        //so no need to throw on exception
        try
        {
            FoodDataHandlerFactory foodDataHandlerFactory = new FoodDataHandlerFactory();
            FoodDataHandler foodDataHandler = (FoodDataHandler) foodDataHandlerFactory.createDataHandler();
            foodDataHandler.loadAllData();;

            Food food = new MainDish(foodID);
            foodDataHandler.setObject(food);
            food = (Food) foodDataHandler.loadFullObject();

            foodDataHandler.setObject(food);
            foodDataHandler.removeObject();
        }
        catch (Exception e)
        {
            return;
        }
    }

    private void deleteOffers() throws DataHandlerException
    {

        //try, catch block is used here because a user might have not made/have any offers
        //so no need to throw on exception
        try
        {
            OfferDataHandlerFactory offerDataHandlerFactory = new OfferDataHandlerFactory();
            OfferDataHandler offerDataHandler = (OfferDataHandler) offerDataHandlerFactory.createDataHandler();
            offerDataHandler.loadAllData();

            LinkedList<String> offerIDs = offerDataHandler.loadOffersIDs(user.getPhone());
            for(String offerID : offerIDs)
            {
                Offer offer = new Discount(offerID);
                offerDataHandler.setObject(offer);
                offer = (Offer) offerDataHandler.loadFullObject();

                offerDataHandler.setObject(offer);
                offerDataHandler.removeObject();
            }
        }
        catch (Exception e)
        {
            return;
        }
    }

    private void deleteMenu() throws DataHandlerException
    {
        if(!(user instanceof Restaurant))
            return;

        //try, catch block is used here because a user might have not made any menus
        //so no need to throw on exception
        try
        {
            MenuDataHandlerFactory menuDataHandlerFactory = new MenuDataHandlerFactory();
            MenuDataHandler menuDataHandler = (MenuDataHandler) menuDataHandlerFactory.createDataHandler();

            Menu menu = new RestaurantMenu(user.getPhone());
            menuDataHandler.setObject(menu);
            menu = (Menu) menuDataHandler.loadFullObject();

            ArrayList<String> foodItemIDs = menu.getItemIDs();
            for(String foodItemID : foodItemIDs)
                deleteFood(foodItemID);

            menuDataHandler.setObject(menu);
            menuDataHandler.removeObject();
        }
        catch (Exception e)
        {
            return;
        }
    }

    private void deleteReviews() throws DataHandlerException
    {

        //try, catch block is used here because a user might have not made/have any reviews
        //so no need to throw on exception
        try
        {
            ReviewDataHandlerFactory reviewDataHandlerFactory = new ReviewDataHandlerFactory();
            ReviewDataHandler reviewDataHandler = (ReviewDataHandler) reviewDataHandlerFactory.createDataHandler();
            reviewDataHandler.loadAllData();

            LinkedList<String> reviewIDs = reviewDataHandler.loadReviewIDs(user.getPhone());
            for(String reviewID : reviewIDs)
            {
                Review review = new RestaurantReview(reviewID);
                reviewDataHandler.setObject(review);
                review = (Review) reviewDataHandler.loadFullObject();

                reviewDataHandler.setObject(review);
                reviewDataHandler.removeObject();
            }
        }
        catch (Exception e)
        {
            return;
        }
    }
}
