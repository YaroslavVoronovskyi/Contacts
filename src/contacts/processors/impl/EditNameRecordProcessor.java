package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Record;
import contacts.processors.IEditRecordActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;
import java.time.LocalDateTime;

public class EditNameRecordProcessor implements IEditRecordActionProcessor {

    private final IRecordService recordService;

    public EditNameRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void doAction(Record record) throws IOException {
        String name = ConsoleReader.getStringFromConsole("Enter the name");
        record.setName(name);
        record.setLastEditDate(LocalDateTime.now());
        recordService.update(record);
        System.out.println("The record updated!");
        System.out.println();
    }

    @Override
    public String getSupportedActionTitle() {
        return "name";
    }
}