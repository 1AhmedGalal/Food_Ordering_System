package userinterfacecomponentcollectingutil;

import datahandlers.DataHandlerException;
import logger.Logger;
import userinterfacecomponentutil.UserInterfaceComponent;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class UserInterfaceCollector
{
    protected ArrayList<UserInterfaceComponent> userInterfaceComponents;

    public UserInterfaceCollector()
    {
        userInterfaceComponents = new ArrayList<>();
    }

    public void display() throws DataHandlerException {
        while(true)
        {
            this.displayComponents();
            System.out.println("-------------------------");
            System.out.println("choose option : ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            try
            {
                this.takeRequest(choice);
            }
            catch (Exception e)
            {
                System.out.println("-------------------------");
                System.out.println(e.getMessage());
                System.out.println("------------------------");
            }
            Logger logger = null;
            try {
                logger = Logger.getInstance(null); //this means that the user logged out

            }
            catch (Exception e)
            {

            }
            if(logger.getUser() == null)
                break;
        }
    }
    public void addComponent(UserInterfaceComponent userInterfaceComponent)
    {
        this.userInterfaceComponents.add(userInterfaceComponent);
    }

    public void removeComponent(UserInterfaceComponent userInterfaceComponent)
    {
        this.userInterfaceComponents.remove(userInterfaceComponent);
    }

    protected void displayComponents()
    {
        int id = 1;

        for(UserInterfaceComponent component : userInterfaceComponents)
        {
            System.out.println(id + ") " + component.getMessage());
            id++;
        }
    }

    protected void takeRequest(int componentNumber) throws RequestException
    {
        componentNumber--;

        if(!isValidRequest(componentNumber))
            throw new RequestException("Invalid Choice");

        boolean isRequested;

        do
        {
            isRequested = false;

            try
            {
                userInterfaceComponents.get(componentNumber).doWork();
            }
            catch (Exception exception)
            {
                System.out.println(exception.getMessage());
                System.out.println("Press 1 to retry and any other key to go back");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                if(choice == 1)
                    isRequested = true;
            }

        }
        while (isRequested);
    }

    protected boolean isValidRequest(int componentNumber)
    {
        return (componentNumber >= 0 && componentNumber < userInterfaceComponents.size());
    }
}
