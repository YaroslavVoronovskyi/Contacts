package contacts.service;

import contacts.model.Record;

import java.util.List;
public interface IRecordService {
    Record get(int index);
    List<Record> getAll();
    void save(Record record);
    void update(Record record);
    void delete(Record record);
    int getRecordsCount();
}
