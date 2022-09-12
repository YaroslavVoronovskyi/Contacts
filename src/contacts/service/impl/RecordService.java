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
    public List<Record> getAll() throws IOException {
        return recordDao.getAll();
    }

    @Override
    public void save(Record record) throws IOException {
        recordDao.save(record);
    }

    @Override
    public void update(Record record) throws IOException {
        recordDao.update(record);
    }

    @Override
    public void delete(Record record) {
        recordDao.delete(record);
    }

    @Override
    public int getRecordsCount() throws IOException {
        return recordDao.getRecordsCount();
    }

    @Override
    public List<Record> getRecordsByQuery(String query) {
        return recordDao.getRecordsByQuery(query);
    }
}
