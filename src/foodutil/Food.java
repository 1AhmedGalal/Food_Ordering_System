package foodutil;
public abstract class Food
{
    protected String name;
    protected String size;
    protected String description;
    protected double price;

    public String getName()
    {
        return name;
    }

    public void setName(String name) throws FoodException
    {
        if(name == null)
            throw new FoodException("Invalid Name");

        this.name = name;
    }

    public Food(String name, String size, String description, double price)
    {
        this.name = name;
        this.size = size;
        this.description = description;
        this.price = price;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size) throws FoodException
    {
        if(name == null)
            throw new FoodException("Invalid Name");

        this.size = size;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price) throws FoodException
    {
        if(price <= 0)
            throw new FoodException("Invalid price");

        this.price = price;
    }

}
