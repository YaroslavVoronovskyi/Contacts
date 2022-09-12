package contacts.service;

import contacts.model.Record;

import java.util.List;
public interface IRecordService {

    List<Record> getAll();

    void save(Record record);

    void update(Record record);

    void delete(Record record);

    int getRecordsCount();

    List<Record> getRecordsByQuery(String query);
}
