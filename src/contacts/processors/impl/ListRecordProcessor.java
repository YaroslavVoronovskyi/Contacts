package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.*;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.List;

public class ListRecordProcessor implements IActionProcessor {

    private final IRecordService recordService;

    public ListRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() throws IOException {
        List<Record> personsList = recordService.getAll();
        int index = 0;
        for (Record record : personsList) {
            index++;
            System.out.println(index + Constants.COMA_SEPARATOR + Constants.DELIMETER + record.getName());
        }
        System.out.println();
        int recordNumber = Integer.parseInt(ConsoleReader.getStringFromConsole("Select a record: "));
        Record record = personsList.get(recordNumber - 1);
        System.out.println(record);
        System.out.println();
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "list";
    }
}