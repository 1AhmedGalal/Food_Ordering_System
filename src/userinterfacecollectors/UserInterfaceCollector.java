package userinterfacecollectors;

import datahandlers.DataHandlerException;
import datahandlers.users.UserDataHandler;
import datahandlers.users.UserFileHandler;
import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class UserInterfaceCollector
{
    protected ArrayList<UserInterfaceComponent> userInterfaceComponents;

    public UserInterfaceCollector()
    {
        userInterfaceComponents = new ArrayList<>();
    }

    public void display() throws Exception {
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

            try
            {
                UserDataHandler userDataHandler = new UserFileHandler(null);
                logger = Logger.getInstance(userDataHandler);

                if(logger.getUser() == null) //this means that the user logged out
                    break;
            }
            catch (Exception e)
            {
                System.out.println("No Data Found!");
            }


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
                else
                    throw new RequestException("");
            }

        }
        while (isRequested);

    }

    protected boolean isValidRequest(int componentNumber)
    {
        return (componentNumber >= 0 && componentNumber < userInterfaceComponents.size());
    }
}
