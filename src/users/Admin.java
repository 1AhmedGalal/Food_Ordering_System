package users;

public class Admin extends User
{
    public Admin()
    {
        super();
    }

    public Admin(String phone, String password) throws UserException
    {
        super(phone, password);
    }

    public Admin(String name, String phone, String password) throws UserException
    {
        super(name, phone, password);
    }
}
