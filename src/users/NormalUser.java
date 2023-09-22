package users;

public class NormalUser extends User
{

    public NormalUser()
    {
        super();
    }

    public NormalUser(String phone) throws UserException
    {
        super(phone);
    }

    public NormalUser(String phone, String password) throws UserException
    {
        super(phone, password);
    }

    public NormalUser(String name, String phone, String password) throws UserException
    {
        super(name, phone, password);
    }
}
