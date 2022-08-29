package contacts.processors.impl;

import contacts.processors.IActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;

public class ExitAppActionProcessor implements IActionProcessor {

    private final IRecordService personService;

    public ExitAppActionProcessor(IRecordService personService) {
        this.personService = personService;
    }

    @Override
    public boolean doAction() throws IOException {
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "exit";
    }
}