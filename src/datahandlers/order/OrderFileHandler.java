package datahandlers.order;

import datahandlers.DataHandlerException;
import datahandlers.foods.FoodType;
import datahandlers.restrauntinterface.RestaurantInterfaceDummyDataHandler;
import foods.Appetizer;
import foods.Drink;
import foods.Food;
import foods.MainDish;
import orders.FoodOrder;
import orders.Order;
import orders.OrderState;

import java.io.*;
import java.util.ArrayList;
import java.util.Set;

public class OrderFileHandler extends OrderDataHandler
{
    private static OrderFileHandler instance = null;


    public static OrderFileHandler getInstance()
    {
        if(instance == null)
            instance = new OrderFileHandler();

        return instance;
    }
    private OrderFileHandler()
    {
        super();
    }

    @Override
    public void saveObject() throws DataHandlerException
    {
        String orderID = order.getOrderID();
        String providerID = order.getProviderID();
        String customerID = order.getCostumerID();

        orders.put(orderID, order);
        addOrder(providerID, orderID, providerOrders);
        addOrder(customerID, orderID, customerOrders);

        saveAllData();
    }

    @Override
    public void removeObject() throws DataHandlerException
    {

        String orderID = order.getOrderID();
        String providerID = order.getProviderID();
        String customerID = order.getCostumerID();

        if(!orders.containsKey(orderID))
            throw new DataHandlerException("Order Not Found");

        orders.remove(orderID);
        removeOrder(providerID, orderID, providerOrders);
        removeOrder(customerID, orderID, customerOrders);

        saveAllData();
    }

    @Override
    public void updateObject() throws DataHandlerException
    {

        String orderID = order.getOrderID();

        if(!orders.containsKey(orderID))
            throw new DataHandlerException("Order Not Found");

        removeObject();
        saveObject();
    }

    @Override
    public Object loadFullObject() throws DataHandlerException
    {
        String orderID = order.getOrderID();

        if(!orders.containsKey(orderID))
            throw new DataHandlerException("Order Not Found");

        return orders.get(orderID);
    }

    @Override
    public void saveAllData() throws DataHandlerException
    {
        if(!allDataLoaded) // this prevents clearing the file and losing all data
            loadAllData();

        try
        {
            clearFile(); //this is done to avoid duplicates

            BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt"));
            writer.write("=");

            Set<String> setOfIDs = orders.keySet();
            for(String orderID : setOfIDs)
            {
                Order order = orders.get(orderID);

                writer.write("\n" + order.getOrderID());
                writer.write("\n" + order.getCostumerID());
                writer.write("\n" + order.getProviderID());
                writer.write("\n" + Double.toString(order.getTotalPrice()));
                writer.write("\n" + order.getOrderState().toString());

                ArrayList<String> foodIDs = order.getFoodIDs();
                if(foodIDs != null && !foodIDs.isEmpty())
                {
                    for(String foodID : foodIDs)
                    {
                        writer.write("\n" + foodID);
                    }
                }

                writer.write("\n" + "=");
            }

            writer.close();
        }
        catch (IOException e)
        {
            throw new DataHandlerException(e.getMessage());
        }

        allDataLoaded = false;
    }

    public void loadAllData() throws DataHandlerException
    {
        if(allDataLoaded)
            return;

        String orderID = null, customerID = null, providerID = null;
        double totalPrice = 0;
        OrderState orderState = null;
        ArrayList<String> foodIDs = new ArrayList<>();

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("orders.txt"));
            String line;

            Order order = null;

            int cnt = 0;

            while((line = reader.readLine()) != null)
            {
                if(line.equals("="))
                {
                    if(cnt != 0) //makes sure that this "=" is not the beginning of the file but the end of a food
                    {
                        order = new FoodOrder(orderID, providerID, customerID, orderState ,foodIDs, totalPrice); //id problem!!!
                        order.setOrderState(orderState);
                        orders.put(orderID, order);
                        addOrder(providerID, orderID, providerOrders);
                        addOrder(customerID, orderID, customerOrders);
                    }

                    cnt = 0;
                    continue;
                }

                switch (cnt)
                {
                    case 0:
                        orderID = line;
                        break;

                    case 1:
                        customerID = line;
                        break;

                    case 2:
                        providerID = line;
                        break;

                    case 3:
                        totalPrice = Double.parseDouble(line);
                        break;

                    case 4:
                        orderState = makeOrderState(line);
                        break;

                    default: //any extra line is for foods
                        foodIDs.add(line);
                        break;
                }

                cnt++;
            }

            reader.close();
        }
        catch (Exception e)
        {
            throw new DataHandlerException(e.getMessage());
        }

        allDataLoaded = true;
    }

    private void clearFile() throws DataHandlerException
    {
        try
        {
            FileWriter fileWriter = new FileWriter("orders.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter, false);
            printWriter.flush();
            printWriter.close();
            fileWriter.close();
        }
        catch (Exception e)
        {
            throw new DataHandlerException(e.getMessage());
        }
    }

    private OrderState makeOrderState(String type)
    {
        switch (type)
        {
            case "PROCESSING" ->
            {
                return OrderState.PROCESSING;
            }
            case "DELIVERED" ->
            {
                return OrderState.DELIVERED;
            }
            default ->
            {
                return OrderState.CANCELED;
            }
        }
    }

}
