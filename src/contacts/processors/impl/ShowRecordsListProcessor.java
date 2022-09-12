package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.*;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.List;

public class ShowRecordsListProcessor implements IActionProcessor {

    private final IRecordService recordService;

    public ShowRecordsListProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() throws IOException {
        List<Record> recordsList = recordService.getAll();
        if (recordsList.size() == 0) {
            System.out.println("No records to show!");
            return true;
        }

        int index = 0;
        for (Record record : recordsList) {
            index++;
            System.out.println(index + Constants.DOT_SEPARATOR + Constants.DELIMETER + record.getName());
        }

        System.out.println();

        int recordNumber = ConsoleReader.getIntFromConsole("Select a record number: ", index);
        Record record = recordsList.get(recordNumber - 1);
        System.out.println(record);

        System.out.println();
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "list";
    }
}