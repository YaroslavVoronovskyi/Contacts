package contacts.service;

import contacts.dao.IRecordDao;
import contacts.model.Record;
import contacts.service.impl.IRecordService;

import java.io.IOException;
import java.util.List;

public class RecordService implements IRecordService {

    private final IRecordDao innerMemoryDao;

    public RecordService(IRecordDao innerMemoryDao) {
        this.innerMemoryDao = innerMemoryDao;
    }

    @Override
    public Record get(int index) {
        return innerMemoryDao.get(index);
    }

    @Override
    public List<Record> getAll() throws IOException, ClassNotFoundException {
        return innerMemoryDao.getAll();
    }

    @Override
    public void save(Record record) throws IOException {
        innerMemoryDao.save(record);
    }

    @Override
    public void update(Record record) throws IOException, ClassNotFoundException {
        innerMemoryDao.update(record);
    }

    @Override
    public void delete(Record record) {
        innerMemoryDao.delete(record);
    }

    @Override
    public int getRecordsCount() throws IOException, ClassNotFoundException {
        return innerMemoryDao.getRecordsCount();
    }
}
