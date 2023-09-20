package datahandlers;

public interface DataHandler
{
    void saveAllData() throws DataHandlerException;

    void loadAllData() throws DataHandlerException;

    void saveObject(Object object) throws DataHandlerException;

    void removeObject(Object object) throws DataHandlerException;

    Object loadFullObject() throws DataHandlerException;

}
