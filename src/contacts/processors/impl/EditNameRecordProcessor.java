package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Record;
import contacts.processors.IEditRecordActionProcessor;
import contacts.service.impl.IRecordService;

import java.io.IOException;

public class EditNameRecordProcessor implements IEditRecordActionProcessor {

    private final IRecordService recordService;

    public EditNameRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void doAction(Record record) throws IOException, ClassNotFoundException {
        String name = ConsoleReader.getStringFromConsole("Enter the name");
        record.setName(name);
        recordService.update(record);
        System.out.println("The record updated!");
        System.out.println();
    }

    @Override
    public String getSupportedActionTitle() {
        return "name";
    }
}