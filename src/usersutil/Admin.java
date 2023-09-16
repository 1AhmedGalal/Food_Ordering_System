package usersutil;

public class Admin extends User
{
    public Admin(String phone, String password)
    {
        super(phone, password);
    }

    public Admin(String name, String phone, String password)
    {
        super(name, phone, password);
    }
}
