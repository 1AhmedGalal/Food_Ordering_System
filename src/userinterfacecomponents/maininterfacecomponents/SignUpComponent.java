package userinterfacecomponents.maininterfacecomponents;

import logger.Logger;
import userinterfacecomponents.UserInterfaceComponent;
import users.NormalUser;
import users.User;

import java.util.Scanner;

public class SignUpComponent extends UserInterfaceComponent
{
    private String name;

    private String phone;

    private String password;

    public SignUpComponent(String message)
    {
        super(message);
        name = null;
        phone = null;
        password = null;
    }

    @Override
    public void doWork() throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name : ");
        name = scanner.nextLine();

        System.out.println("Phone : ");
        phone = scanner.next();

        System.out.println("Password : ");
        password = scanner.next();

        if(name == null || phone == null || password == null)
            throw new Exception("Invalid data. Please Enter All Fields");
        else if(password.length() < 8)
            throw new Exception("Invalid password (minimum length is 8)");
        else if(phone.length() < 11)
            throw new Exception("Invalid phone");

        addUser();
    }

    private void addUser() throws Exception
    {
        User user = new NormalUser(name, phone, password);
        Logger logger = Logger.getInstance();
        logger.signUp(user);
    }
}
