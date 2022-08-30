package contacts.service;

import contacts.model.Record;

import java.util.ArrayList;
import java.util.List;

public class RecordServiceImpl implements IRecordService {
    List<Record> phoneBook = new ArrayList<>();

    @Override
    public Record get(int index) {
        return phoneBook.get(index);
    }

    @Override
    public List<Record> getAll() {
        return phoneBook;
    }

    @Override
    public void save(Record record) {
        phoneBook.add(record);
    }

    @Override
    public void update(Record record) {
        phoneBook.add(record);
    }

    @Override
    public void delete(Record record) {
        phoneBook.add(record);
    }

    @Override
    public int getRecordsCount() {
        return phoneBook.size();
    }
}
