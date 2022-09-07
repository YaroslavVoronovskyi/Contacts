package contacts.service;

import contacts.model.Record;

import java.io.IOException;
import java.util.List;
public interface IRecordService {
    Record getByIndex(int index);
    List<Record> getAll() throws IOException;
    void save(Record record) throws IOException;
    void update(Record record) throws IOException;
    void delete(Record record);
    int getRecordsCount() throws IOException;
    List<Record> getRecordsByQuery(String query);
}
