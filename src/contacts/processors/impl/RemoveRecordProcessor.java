package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.IActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.List;

public class RemoveRecordProcessor implements IActionProcessor {

    private final IRecordService recordService;

    public RemoveRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() throws IOException {
        List<Record> recordsList = recordService.getAll();
        if (recordsList.size() == 0) {
            System.out.println("No records to remove!");
            return false;
        }
        int index = 0;
        for (Record record : recordsList) {
            index++;
            System.out.println(index + Constants.DELIMETER + record);
        }
        int recordNumber = ConsoleReader.getIntFromConsole("Select a record: ");
        recordsList.remove(recordNumber - 1);
        System.out.println("The record removed!");
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "remove";
    }
}
