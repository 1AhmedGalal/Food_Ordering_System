package users;

public abstract class User
{

    protected String name;

    protected String phone;

    protected String password;

    public User()
    {
        name = null;
        phone = null;
        password = null;
    }

    public User(String phone) throws UserException
    {
        if(phone == null)
            throw new UserException("Invalid Data");

        this.phone = phone;
    }

    public User(String name, String phone, String password) throws UserException
    {
        if(name == null || phone == null || password == null)
            throw new UserException("Invalid Data");

        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public User(String phone, String password) throws UserException
    {
        if(phone == null || password == null)
            throw new UserException("Invalid Data");

        this.phone = phone;
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) throws UserException
    {
        if(name == null)
            throw new UserException("No name Found");

        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone) throws UserException
    {
        if(phone == null)
            throw new UserException("No Phone Found");

        this.phone = phone;
    }
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password) throws UserException
    {
        if(password == null)
            throw new UserException("No Password Found");

        this.password = password;
    }
}
