package userinterfacecomponents.restaurantmenucomponentutil;

import foodutil.Appetizer;
import foodutil.Drink;
import foodutil.Food;
import foodutil.MainDish;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.Restaurant;

import java.util.Scanner;

public class AddMenuItemComponent extends UserInterfaceComponent
{
    public AddMenuItemComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("choose 1-add main dish\n2-add appetizer\n3-add drink");
        int choice = scanner.nextInt();

        if(choice < 1 || choice > 3)
            throw new Exception("Invalid Choice");

        String name;
        System.out.println("name : ");
        name = scanner.next();

        String description;
        System.out.println("description : ");
        description = scanner.next();

        String size;
        System.out.println("size : ");
        size = scanner.next();

        double price;
        System.out.println("price : ");
        price = scanner.nextDouble();;

        Food food = null;
        switch (choice)
        {
            case 1:
                food = new MainDish(name, size, description, price);
                break;

            case 2:
                food = new Appetizer(name, size, description, price);
                break;

            case 3:
                String cupType;
                System.out.println("Cup Type : ");
                cupType = scanner.next();
                food = new Drink(name, size, description, price, cupType);
                break;
        }

        Logger logger = Logger.getInstance(null);
        Restaurant restaurant = (Restaurant) logger.getUser();
        //Menu menu = restaurant.getMenu();
        //menu.addItem(food);
    }
}
