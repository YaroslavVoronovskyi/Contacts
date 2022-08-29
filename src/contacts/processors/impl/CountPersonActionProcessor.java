package contacts.processors.impl;

import contacts.processors.IActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;

public class CountPersonActionProcessor implements IActionProcessor {

    private final IRecordService personService;

    public CountPersonActionProcessor(IRecordService personService) {
        this.personService = personService;
    }

    @Override
    public boolean doAction() throws IOException {
        System.out.println("The Phone Book has " + personService.getRecordsCount() + " records.");
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "count";
    }
}
