package contacts.dao.impl;

import contacts.dao.IRecordDao;
import contacts.model.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class InMemoryDao implements IRecordDao {

    List<Record> phoneBook = new ArrayList<>();

    @Override
    public Record getByIndex(int index) {
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
    public void update(Record newRecord) {
        Predicate<Record> isQualified = record -> record.getPhoneNumber().equals(newRecord.getPhoneNumber());
        phoneBook.removeIf(isQualified);
        phoneBook.add(newRecord);
    }

    @Override
    public void delete(Record newRecord) {
        Predicate<Record> isQualified = record -> record.getPhoneNumber().equals(newRecord.getPhoneNumber());
        phoneBook.removeIf(isQualified);
    }

    @Override
    public int getRecordsCount() {
        return phoneBook.size();
    }
}
