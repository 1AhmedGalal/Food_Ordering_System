package datahandlers.menu;

import datahandlers.DataHandler;
import menu.Menu;

import java.util.Hashtable;

public abstract class MenuDataHandler implements DataHandler
{
    protected Menu menu;

    protected boolean allDataLoaded;

    protected Hashtable<String, Menu> menus; // a lot of fast lookups is needed

    public MenuDataHandler()
    {
        menu = null;
        allDataLoaded = false;
        menus = new Hashtable<>();
    }
}
