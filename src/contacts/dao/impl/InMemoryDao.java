package contacts.dao.impl;

import contacts.dao.IRecordDao;
import contacts.model.Record;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDao implements IRecordDao {

    List<Record> phoneBook = new ArrayList<>();

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
        removeByCondition(newRecord);
        phoneBook.add(newRecord);
    }

    @Override
    public void delete(Record newRecord) {
        removeByCondition(newRecord);
    }

    @Override
    public int getRecordsCount() {
        return phoneBook.size();
    }

    @Override
    public List<Record> getRecordsByQuery(String query) {
        List<Record> resultsList = new ArrayList<>();
        for (Record record : phoneBook) {
            if (record.matches(query)) {
                resultsList.add(record);
            }
        }
        return resultsList;
    }

    private void removeByCondition(Record record) {
        phoneBook.removeIf(r -> r.getId().equals(record.getId()));
    }
}
