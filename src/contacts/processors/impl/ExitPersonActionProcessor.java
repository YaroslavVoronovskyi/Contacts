package contacts.processors.impl;

import contacts.model.Record;
import contacts.processors.IPersonActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;

public class ExitPersonActionProcessor implements IPersonActionProcessor {
    private final IRecordService personService;

    public ExitPersonActionProcessor(IRecordService personService) {
        this.personService = personService;
    }

    @Override
    public void doAction(Record record) throws IOException {

    }

    @Override
    public String getSupportedActionTitle() {
        return "exit";
    }
}
