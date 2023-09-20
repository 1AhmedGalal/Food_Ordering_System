package datahandlers;

public interface DataHandler
{
    void saveAllData();

    void loadAllData();

    void saveObject(Object object);

    void removeObject(Object object);

    Object loadFullObject();

}
