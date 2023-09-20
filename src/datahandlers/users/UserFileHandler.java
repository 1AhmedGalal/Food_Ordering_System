package datahandlers.users;

import datahandlers.DataHandlerException;
import users.*;

import java.io.*;

public class UserFileHandler extends UserDataHandler
{
    public UserFileHandler(User user)
    {
        super(user);
    }

    @Override
    public void saveAllData() throws DataHandlerException
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"));
            writer.write("=");

            for (int i = 0; i < users.size(); i++)
            {
                User user = users.get(i);
                UserType userType = userTypes.get(i);

                writer.write("\n" + userType.toString());
                writer.write("\n" + user.getName());
                writer.write("\n" + user.getPhone());
                writer.write("\n" + user.getPassword());
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

            int cnt = 0;
            while((line = reader.readLine()) != null)
            {
                if(line.equals("="))
                {
                    cnt = 0;
                    continue;
                }

                switch (cnt)
                {
                    case 0:
                        if(line.equals("NORMAL"))
                        {
                            user = new NormalUser();
                            userType = UserType.NORMAL;
                        }
                        else if(line.equals("ONLINE_RESTAURANT"))
                        {
                            user = new OnlineRestaurant();
                            userType = UserType.ONLINE_RESTAURANT;

                        }
                        else if(line.equals("ONSITE_RESTAURANT"))
                        {
                            user = new OnsiteRestaurant();
                            userType = UserType.ONSITE_RESTAURANT;
                        }
                        else
                        {
                            user = new Admin();
                            userType = UserType.ADMIN;
                        }
                        break;

                    case 1:
                        user.setName(line);
                        break;

                    case 2:
                        user.setPhone(line);
                        break;

                    case 3:
                        user.setPassword(line);
                        break;

                    default:
                        break;
                }

                users.add(user);
                userTypes.add(userType);

                cnt++;
            }

            reader.close();
        }
        catch (IOException e)
        {
            throw new DataHandlerException(e.getMessage());
        } catch (UserException e)
        {
            throw new DataHandlerException(e.getMessage());
        }

        allDataLoaded = true;
    }

    @Override
    public void saveObject(Object object) throws DataHandlerException
    {
        User user = (User) object;
        UserType userType = null;

        if(user instanceof NormalUser)
            userType = UserType.NORMAL;
        else if(user instanceof OnlineRestaurant)
            userType = UserType.ONLINE_RESTAURANT;
        else if(user instanceof OnsiteRestaurant)
            userType = UserType.ONSITE_RESTAURANT;
        else
            userType = UserType.ADMIN;

        users.add(user);
        userTypes.add(userType);

        saveAllData();
    }

    @Override
    public void removeObject(Object object) throws DataHandlerException
    {
        User user = (User) object;
        String phone = user.getPhone();

        for(User currentUser : users)
        {
            if(currentUser.getPhone().equals(phone))
            {
                users.remove(currentUser);
                saveAllData();
                return;
            }
        }

        throw new DataHandlerException("User Not Found");
    }

    @Override
    public Object loadFullObject() throws DataHandlerException
    {
        String phone = user.getPhone();

        for(User currentUser : users)
        {
            if(currentUser.getPhone().equals(phone))
                return currentUser;
        }

        throw new DataHandlerException("User Not Found");
    }

    @Override
    public boolean userPhoneExists()
    {
        String phone = user.getPhone();

        for(User currentUser : users)
        {
            if(currentUser.getPhone().equals(phone))
                return true;
        }

        return false;
    }

    @Override
    public boolean validUserData()
    {
        String phone = user.getPhone();
        String password = user.getPassword();

        for(User currentUser : users)
        {
            if(currentUser.getPhone().equals(phone) && currentUser.getPassword().equals(password))
                return true;
        }

        return false;
    }
}
