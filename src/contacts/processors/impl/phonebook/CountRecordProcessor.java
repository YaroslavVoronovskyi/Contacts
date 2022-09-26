package contacts.processors.impl.phonebook;

import contacts.processors.IPhoneBookActionProcessor;
import contacts.service.IRecordService;

public class CountRecordProcessor implements IPhoneBookActionProcessor {

    private final IRecordService recordService;

    public CountRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() {
        System.out.println("The Phone Book has " + recordService.getRecordsCount() + " records.");
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "count";
    }
}
