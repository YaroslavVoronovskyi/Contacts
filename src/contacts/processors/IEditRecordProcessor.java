package contacts.processors;

import contacts.model.Record;

public interface IEditRecordProcessor {

    void editRecord(Record record);

    String getSupportedFieldEditionName();
}
