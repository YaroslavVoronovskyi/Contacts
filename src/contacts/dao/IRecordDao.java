package contacts.dao;

import contacts.model.Record;

import java.util.List;

public interface IRecordDao {

    List<Record> getAll();

    void save(Record record);

    void update(Record record);

    void delete(Record record);

    int getRecordsCount();

    List<Record> getRecordsByQuery(String query);
}
