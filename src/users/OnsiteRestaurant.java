package users;

import java.util.LinkedList;
import java.util.List;

public class OnsiteRestaurant extends Restaurant
{
    protected LinkedList<String> sites; // linked list is used as restaurants will remove and add new sites frequently but no lookups needed

    public OnsiteRestaurant()
    {
        super();
    }

    public OnsiteRestaurant(String phone) throws UserException
    {
        super(phone);
        sites = new LinkedList<>();
    }
    public OnsiteRestaurant(Restaurant restaurant)
    {
        super(restaurant);
        sites = new LinkedList<>();
    }

    public OnsiteRestaurant(String phone, String password) throws UserException
    {
        super(phone, password);
        sites = new LinkedList<>();
    }

    public OnsiteRestaurant(String name, String phone, String password) throws UserException
    {
        super(name, phone, password);
        sites = new LinkedList<>();
    }

    public OnsiteRestaurant(String name, String phone, String password, LinkedList<String> sites) throws UserException
    {
        super(name, phone, password);
        this.sites = sites;
    }

    public void addSite(String site) throws Exception
    {
        if(site == null)
            throw new Exception("Invalid site");
        else if(sites == null)
            sites = new LinkedList<>();

        sites.add(site);
    }

    public void removeSite(int index) throws UserException
    {
        index--;

        if(!isValidSite(index))
            throw new UserException("Invalid choice");

        sites.remove(index);
    }

    public LinkedList<String> getSites()
    {
        return sites;
    }

    protected boolean isValidSite(int index)
    {
        return index >= 0 && index < sites.size();
    }
}
