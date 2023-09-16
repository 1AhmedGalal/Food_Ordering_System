package usersutil;

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

    public User(String name, String phone, String password)
    {
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public User(String phone, String password)
    {
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
