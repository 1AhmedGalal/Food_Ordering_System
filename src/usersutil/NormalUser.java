package usersutil;

public class NormalUser extends User
{
    public NormalUser(String phone, String password)
    {
        super(phone, password);
    }
    public NormalUser(String name, String phone, String password)
    {
        super(name, phone, password);
    }
}
