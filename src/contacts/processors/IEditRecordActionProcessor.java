package contacts.processors;

import contacts.model.Record;

import java.io.IOException;

public interface IEditRecordActionProcessor {
    void doAction(Record record) throws IOException, ClassNotFoundException;

    String getSupportedActionTitle();
}
