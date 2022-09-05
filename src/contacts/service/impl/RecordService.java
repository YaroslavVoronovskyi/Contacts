package contacts.service.impl;

import contacts.dao.IRecordDao;
import contacts.model.Record;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.List;

public class RecordService implements IRecordService {

    private final IRecordDao recordDao;

    public RecordService(IRecordDao recordDao) {
        this.recordDao = recordDao;
    }

    @Override
    public Record getByIndex(int index) {
        return recordDao.getByIndex(index);
    }

    @Override
    public List<Record> getAll() throws IOException, ClassNotFoundException {
        return recordDao.getAll();
    }

    @Override
    public void save(Record record) throws IOException {
        recordDao.save(record);
    }

    @Override
    public void update(Record record) throws IOException, ClassNotFoundException {
        recordDao.update(record);
    }

    @Override
    public void delete(Record record) {
        recordDao.delete(record);
    }

    @Override
    public int getRecordsCount() throws IOException, ClassNotFoundException {
        return recordDao.getRecordsCount();
    }

    @Override
    public List<Record> getRecordsByQuery(String query) {
        return recordDao.getRecordsByQuery(query);
    }
}
