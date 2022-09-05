package contacts.dao.impl;

import contacts.Constants;
import contacts.dao.IRecordDao;
import contacts.model.Record;
import contacts.util.SerializationUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRecordDao implements IRecordDao {

    @Override
    public Record getByIndex(int index) {
        return null;
    }

    @Override
    public List<Record> getAll() throws IOException, ClassNotFoundException {
        List<Record> recordsList = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(Constants.FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Record record = (Record) objectInputStream.readObject();
        recordsList.add(record);
        return recordsList;
    }

    @Override
    public void save(Record record) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(Constants.FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(record);
        objectOutputStream.close();
    }

    @Override
    public void update(Record record) throws IOException, ClassNotFoundException {
    }

    @Override
    public void delete(Record record) {

    }

    @Override
    public int getRecordsCount() throws IOException, ClassNotFoundException {
        List<Record> recordsList = new ArrayList<>();
        Record record = (Record) SerializationUtil.deserializeObject(Constants.FILE_NAME);
        recordsList.add(record);
        return recordsList.size();
    }
}
