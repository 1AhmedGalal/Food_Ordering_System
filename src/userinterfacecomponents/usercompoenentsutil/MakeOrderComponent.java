package userinterfacecomponents.usercompoenentsutil;

import userinterfacecomponents.UserInterfaceComponent;

public class MakeOrderComponent extends UserInterfaceComponent
{
    public MakeOrderComponent(String message)
    {
        super(message);
    }

    @Override
    public void doWork() throws Exception
    {
//        Logger logger = Logger.getInstance();
//        User user = logger.getUser();
//
//        Scanner scanner = new Scanner(System.in);
//        String input;
//
//        System.out.println("Please Enter Restaurant Name : ");
//        input = scanner.next();
//
//        Restaurant restaurant = (Restaurant) new OnlineRestaurant(input, null ,null);
//        DataHandlerFactory dataHandlerFactory = new UserDataHandlerFactory();
//        UserDataHandler userDataHandler = (UserDataHandler) dataHandlerFactory.createDataHandler();
//        userDataHandler.setObject(restaurant);
//        restaurant = (Restaurant) userDataHandler.loadFullObject();
//
//        Menu menu = null; ///needs fix
//        ArrayList<String> menuItems = menu.getItemsNames();
//        for(String menuItem : menuItems)
//            System.out.println(menuItem);
//
//        ArrayList<Food> foods = new ArrayList<>();
//        do
//        {
//            System.out.println("Enter Item number : ");
//            int choice = scanner.nextInt();
//           // foods.add(menu.getItem(choice));
//
//            System.out.println("Would you like to continue adding food ? (y/n)");
//            input = scanner.next();
//
//        }
//        while (input.charAt(0) == 'y');
//
//        String id = user.getPhone()+restaurant.getPhone();
//        Order order = new FoodOrder(user, restaurant, foods, id);
//
//        DataHandler dataHandler = new OrderDummyDataHandler(user);
//        OrderReceiver orderReceiver = new FoodOrderReceiver(dataHandler, user);
//        orderReceiver.AddOrder(order);
    }
}
