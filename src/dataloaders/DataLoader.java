package dataloaders;

public interface DataLoader
{
    void saveAllData();

    void loadAllData();

    void saveObject(Object object);

    void removeObject(Object object);

    Object loadFullObject();

}
