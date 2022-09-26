package contacts.processors.impl.edit;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.IEditRecordProcessor;
import contacts.service.IRecordService;

import java.time.LocalDateTime;

public class EditNameRecordProcessor implements IEditRecordProcessor {

    private final IRecordService recordService;

    public EditNameRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void editRecord(Record record) {
        String name = ConsoleReader.getStringFromConsole("Enter the name of the person:",
                Constants.NAME_CHECK_PATTERN, Constants.WRONG_NAME_FORMAT_ERROR);
        record.setName(name);
        record.setLastEditDate(LocalDateTime.now());
        recordService.update(record);
        System.out.println("The record updated!");
        System.out.println();
    }

    @Override
    public String getSupportedFieldEditionName() {
        return "name";
    }
}