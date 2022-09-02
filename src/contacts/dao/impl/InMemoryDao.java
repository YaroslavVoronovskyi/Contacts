package contacts.dao.impl;

import contacts.dao.IRecordDao;
import contacts.model.Record;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDao implements IRecordDao {

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
    public void update(Record newRecord) {
        Record oldRecord = phoneBook.stream().filter(record -> record.getPhoneNumber()
                .equals(newRecord.getPhoneNumber())).findAny().orElse(null);
        if (oldRecord == null) {
            System.out.println("Record can not be null");
        }
        phoneBook.remove(oldRecord);
        phoneBook.add(newRecord);
    }

    @Override
    public void delete(Record newRecord) {
        Record oldRecord = phoneBook.stream().filter(record -> record.getPhoneNumber()
                .equals(newRecord.getPhoneNumber())).findAny().orElse(null);
        if (oldRecord == null) {
            System.out.println("Record can not be null");
        }
        phoneBook.remove(oldRecord);
    }

    @Override
    public int getRecordsCount() {
        return phoneBook.size();
    }
}
