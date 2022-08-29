package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Record;
import contacts.processors.IPersonActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;

public class EditPersonNameActionProcessor implements IPersonActionProcessor {

    private final IRecordService recordService;

    public EditPersonNameActionProcessor(IRecordService personService) {
        this.recordService = personService;
    }

    @Override
    public void doAction(Record record) throws IOException {
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