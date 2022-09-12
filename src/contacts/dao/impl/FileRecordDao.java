package contacts.dao.impl;

import contacts.Constants;
import contacts.dao.IRecordDao;
import contacts.model.Record;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileRecordDao implements IRecordDao {
    List<Record> phoneBook = new LinkedList<>();

    public FileRecordDao() {
        initPhoneBook();
    }

    @Override
    public List<Record> getAll() {
        return phoneBook;
    }

    @Override
    public void save(Record record) {
        phoneBook.add(record);
        writeObjectsToFile(phoneBook);
    }

    @Override
    public void update(Record record) throws IOException {
        removeByCondition(record);
        phoneBook.add(record);
        writeObjectsToFile(phoneBook);
    }

    @Override
    public void delete(Record record) {
        removeByCondition(record);
        writeObjectsToFile(phoneBook);
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

    private void initPhoneBook() {
        try {
            FileInputStream fileInputStream = new FileInputStream(Constants.FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                try {
                    Record record = (Record) objectInputStream.readObject();
                    phoneBook.add(record);
                } catch (IOException exception) {
                    break;
                }
            }
            objectInputStream.close();
        } catch (ClassNotFoundException | IOException exception) {
            exception.printStackTrace();
        }
    }

    private void removeByCondition(Record record) {
        phoneBook.removeIf(r -> r.getId().equals(record.getId()));
    }

    private void writeObjectsToFile(List<Record> phoneBook) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Constants.FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Record currentRecord : phoneBook) {
                objectOutputStream.writeObject(currentRecord);
            }
            objectOutputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
