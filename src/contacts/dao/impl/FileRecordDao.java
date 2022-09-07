package contacts.dao.impl;

import contacts.Constants;
import contacts.dao.IRecordDao;
import contacts.model.Record;
import contacts.util.SerializationUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileRecordDao implements IRecordDao {
    List<Record> phoneBook = new LinkedList<>();

    @Override
    public Record getByIndex(int index) {
        return null;
    }

    @Override
    public List<Record> getAll() {
        try {
            FileInputStream fileInputStream = new FileInputStream(Constants.FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                try {
                    Record record = (Record) objectInputStream.readObject();
                    phoneBook.removeIf(r -> r.getId().equals(record.getId()));
                    phoneBook.add(record);
                } catch (IOException exception) {
                    break;
                }
            }
            objectInputStream.close();
        } catch (ClassNotFoundException | IOException exception) {
            exception.printStackTrace();
        }
        return phoneBook;
    }

    @Override
    public void save(Record record) {
        phoneBook.add(record);
        SerializationUtil.serializeObject(phoneBook);
    }

    @Override
    public void update(Record record) throws IOException {
        removeByCondition(record);
        phoneBook.add(record);
        SerializationUtil.serializeObject(phoneBook);
    }

    @Override
    public void delete(Record record) {
        removeByCondition(record);
        SerializationUtil.serializeObject(phoneBook);
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
