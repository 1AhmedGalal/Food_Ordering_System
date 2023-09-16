package userinterfacecomponentcollectingutil;

import datasavingutil.admininterfaceutil.AdminInterfaceDataLoader;
import datasavingutil.admininterfaceutil.AdminInterfaceDummyDataLoader;
import datasavingutil.maininterfaceutil.MainInterfaceDataLoader;
import datasavingutil.maininterfaceutil.MainInterfaceDummyDataLoader;
import loggingutil.Logger;

import java.util.Scanner;

public class AdminInterface extends UserInterfaceCollector
{
    public AdminInterface()
    {
        super();
        AdminInterfaceDataLoader adminInterfaceDataLoader = new AdminInterfaceDummyDataLoader(this);
        adminInterfaceDataLoader.loadAllData();
    }

}
