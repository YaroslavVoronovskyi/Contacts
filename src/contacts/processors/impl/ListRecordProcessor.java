package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.*;
import contacts.service.impl.IRecordService;

import java.io.IOException;
import java.util.List;

public class ListRecordProcessor implements IActionProcessor {

    private final IRecordService recordService;

    public ListRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() throws IOException, ClassNotFoundException {
        List<Record> recordsList = recordService.getAll();
        int index = 0;
        for (Record record : recordsList) {
            index++;
            System.out.println(index + Constants.DOT_SEPARATOR + Constants.DELIMETER + record.getName());
        }
        System.out.println();
        int recordNumber = ConsoleReader.getIntFromConsole("Select a record: ");
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