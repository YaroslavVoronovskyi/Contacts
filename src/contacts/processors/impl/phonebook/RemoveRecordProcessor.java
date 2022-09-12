package contacts.processors.impl.phonebook;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.IPhoneBookActionProcessor;
import contacts.service.IRecordService;

import java.util.List;

public class RemoveRecordProcessor implements IPhoneBookActionProcessor {

    private final IRecordService recordService;

    public RemoveRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() {
        List<Record> recordsList = recordService.getAll();
        if (recordsList.size() == 0) {
            System.out.println("No records to remove!");
            return true;
        }

        int index = 0;
        for (Record record : recordsList) {
            index++;
            System.out.println(index + Constants.DOT_SEPARATOR + Constants.DELIMETER + record.getName());
        }

        int recordNumber = ConsoleReader.getIntFromConsole("Select a record: ", index);
        recordService.delete(recordsList.get(recordNumber - 1));
        System.out.println("The record removed!");

        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "remove";
    }
}
