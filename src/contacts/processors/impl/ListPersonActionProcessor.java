package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.*;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.List;

public class ListPersonActionProcessor implements IActionProcessor {

    private final IRecordService personService;
    private final IProcessorFactory processorFactory;
    public ListPersonActionProcessor(IRecordService personService, IProcessorFactory processorFactory) {
        this.personService = personService;
        this.processorFactory = processorFactory;
    }

    @Override
    public boolean doAction() throws IOException {
        List<Record> personsList = personService.getAll();
        int index = 0;
        for (Record record : personsList) {
            index++;
            System.out.println(index + "." + Constants.DELIMETER + record.getName());
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