package datahandlers;

public interface DataHandler
{
    void setObject(Object object);
    void saveObject() throws DataHandlerException;

    void removeObject() throws DataHandlerException;

    void updateObject() throws DataHandlerException;

    Object loadFullObject() throws DataHandlerException;

    void saveAllData() throws DataHandlerException;

    void loadAllData() throws DataHandlerException;

    void alertUpdate();
}
