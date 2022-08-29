package contacts.processors;

import contacts.model.Record;

import java.io.IOException;

public interface IPersonActionProcessor {
    void doAction(Record record) throws IOException;

    String getSupportedActionTitle();
}
