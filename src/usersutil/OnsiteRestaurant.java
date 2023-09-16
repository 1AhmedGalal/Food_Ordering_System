package usersutil;

import menuutil.Menu;

import java.util.ArrayList;

public class OnsiteRestaurant extends Restaurant
{
    ArrayList<String> sites;

    public OnsiteRestaurant(Restaurant restaurant)
    {
        super(restaurant);
    }

    public OnsiteRestaurant(String phone, String password)
    {
        super(phone, password);
        sites = new ArrayList<>();
    }

    public OnsiteRestaurant(String name, String phone, String password, Menu menu)
    {
        super(name, phone, password, menu);
        sites = new ArrayList<>();
    }

    public OnsiteRestaurant(String name, String phone, String password, Menu menu, ArrayList<String> sites)
    {
        super(name, phone, password, menu);
        this.sites = sites;
    }


    public void addSite(String site) throws Exception
    {
        if(site == null)
            throw new Exception("Invalid site");

        sites.add(site);
    }

    public void removeSite(int index) throws Exception
    {
        index--;

        if(!isValidSite(index))
            throw new Exception("Invalid choice");

        sites.remove(index);
    }

    public ArrayList<String> getSites()
    {
        return sites;
    }

    protected boolean isValidSite(int index)
    {
        return index >= 0 && index < sites.size();
    }
}
