package datahandlers.users;

import datahandlers.DataHandlerException;
import users.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class UserFileHandler extends UserDataHandler
{

    public UserFileHandler()
    {
        super();
    }

    @Override
    public void saveAllData() throws DataHandlerException
    {
        if(!allDataLoaded) // this prevents clearing the file and losing all data
            loadAllData();

        try
        {
            clearFile(); //this is done to avoid duplicates

            BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"));
            writer.write("=");

            Set<String> setOfPhones = users.keySet();
            for(String phone : setOfPhones)
            {
                User user = users.get(phone);
                UserType userType = userTypes.get(phone);

                writer.write("\n" + userType.toString());
                writer.write("\n" + user.getName());
                writer.write("\n" + user.getPhone());
                writer.write("\n" + user.getPassword());

                if(user instanceof OnsiteRestaurant)
                {
                    LinkedList<String> sites = ((OnsiteRestaurant) user).getSites();

                    if(sites != null && !sites.isEmpty())
                    {
                        for(String site : sites)
                            writer.write("\n" + site);
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

    @Override
    public void loadAllData() throws DataHandlerException
    {
        if(allDataLoaded)
            return;

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String line;

            User user = null;
            UserType userType = null;
            String phone = null;
            ArrayList<String> tempContainer = null;

            int cnt = 0;

            while((line = reader.readLine()) != null)
            {
                if(line.equals("="))
                {
                    if(cnt != 0) //makes sure that this "=" is not the beginning of the file but the end of a user
                    {
                        users.put(phone, user);
                        userTypes.put(phone, userType);
                    }

                    cnt = 0;
                    continue;
                }

                switch (cnt)
                {
                    case 0:
                        user = makeUser(line);
                        userType = makeUserType(line);
                        break;

                    case 1:
                        user.setName(line);
                        break;

                    case 2:
                        phone = line;
                        user.setPhone(line);
                        break;

                    case 3:
                        user.setPassword(line);
                        break;

                    default:
                        ///if extra lines are found then this is an onsite restaurant
                        ((OnsiteRestaurant) user).addSite(line);
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

    @Override
    public void saveObject() throws DataHandlerException
    {
        UserType userType = null;

        if(user instanceof NormalUser)
            userType = UserType.NORMAL;
        else if(user instanceof OnlineRestaurant)
            userType = UserType.ONLINE_RESTAURANT;
        else if(user instanceof OnsiteRestaurant)
            userType = UserType.ONSITE_RESTAURANT;
        else
            userType = UserType.ADMIN;

        String phone = user.getPhone();
        users.put(phone, user);
        userTypes.put(phone, userType);

        saveAllData();
    }

    @Override
    public void removeObject() throws DataHandlerException
    {
        String phone = user.getPhone();

        if(!users.containsKey(phone))
            throw new DataHandlerException("User Not Found");

        users.remove(phone);
        saveAllData();
    }

    @Override
    public void updateObject() throws DataHandlerException
    {
        String phone = user.getPhone();

        if(!users.containsKey(phone))
            throw new DataHandlerException("User Not Found");

        removeObject();
        saveObject();
    }

    @Override
    public Object loadFullObject() throws DataHandlerException
    {
        String phone = user.getPhone();

        if(!userPhoneExists())
            throw new DataHandlerException("User Not Found");

        return users.get(phone);
    }

    @Override
    public boolean userPhoneExists()
    {
        String phone = user.getPhone();
        return users.containsKey(phone);
    }

    @Override
    public boolean validUserData()
    {
        String phone = user.getPhone();
        String password = user.getPassword();

        if(!userPhoneExists())
            return false;

        User currentUser = users.get(phone);
        return currentUser.getPassword().equals(password);
    }

    private void clearFile() throws DataHandlerException
    {
        try
        {
            FileWriter fileWriter = new FileWriter("users.txt", false);
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

    private User makeUser(String line)
    {
        switch (line)
        {
            case "NORMAL" ->
            {
                return new NormalUser();
            }
            case "ONLINE_RESTAURANT" ->
            {
                return new OnlineRestaurant();
            }
            case "ONSITE_RESTAURANT" ->
            {
                return new OnsiteRestaurant();
            }
            default ->
            {
                return new Admin();
            }
        }
    }

    private UserType makeUserType(String line)
    {
        switch (line)
        {
            case "NORMAL" ->
            {
                return UserType.NORMAL;
            }
            case "ONLINE_RESTAURANT" ->
            {
                return UserType.ONLINE_RESTAURANT;
            }
            case "ONSITE_RESTAURANT" ->
            {
                return UserType.ONSITE_RESTAURANT;
            }
            default ->
            {
                return UserType.ADMIN;
            }
        }
    }
}
