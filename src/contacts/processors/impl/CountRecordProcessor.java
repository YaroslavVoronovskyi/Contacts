package contacts.processors.impl;

import contacts.processors.IActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;

public class CountRecordProcessor implements IActionProcessor {

    private final IRecordService recordService;

    public CountRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() throws IOException, ClassNotFoundException {
        System.out.println("The Phone Book has " + recordService.getRecordsCount() + " records.");
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "count";
    }
}
