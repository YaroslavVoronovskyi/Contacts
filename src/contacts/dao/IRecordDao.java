package contacts.dao;

import contacts.model.Record;

import java.io.IOException;
import java.util.List;

public interface IRecordDao {
    Record getByIndex(int index);
    List<Record> getAll() throws IOException, ClassNotFoundException;
    void save(Record record) throws IOException;
    void update(Record record) throws IOException, ClassNotFoundException;
    void delete(Record record);
    int getRecordsCount() throws IOException, ClassNotFoundException;
    List<Record> getRecordsByQuery(String query);
}
