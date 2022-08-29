package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.IActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.List;

public class RemovePersonActionProcessor implements IActionProcessor {

    private final IRecordService recordService;

    public RemovePersonActionProcessor(IRecordService personService) {
        this.recordService = personService;
    }

    @Override
    public boolean doAction() throws IOException {
        List<Record> personsList = recordService.getAll();
        if (personsList.size() == 0) {
            System.out.println("No records to remove!");
            return false;
        }
        int index = 0;
        for (Record record : personsList) {
            index++;
            System.out.println(index + Constants.DELIMETER + record);
        }
        int recordNumber = Integer.parseInt(ConsoleReader.getStringFromConsole("Select a record: "));
        personsList.remove(recordNumber - 1);
        System.out.println("The record removed!");
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "remove";
    }
}
