package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.processors.IActionProcessor;
import contacts.processors.IRecordActionProcessor;
import contacts.processors.IRecordProcessorFactory;
import contacts.service.IRecordService;

import java.io.IOException;

public class AddNewRecordProcessor implements IActionProcessor {

    private final IRecordService personService;
    private final IRecordProcessorFactory recordProcessorFactory;

    public AddNewRecordProcessor(IRecordService personService, IRecordProcessorFactory recordProcessorFactory) {
        this.personService = personService;
        this.recordProcessorFactory = recordProcessorFactory;
    }

    @Override
    public boolean doAction() throws IOException {
        String actionTitle = ConsoleReader.getStringFromConsole("Enter the type (person, organization):");
        IRecordActionProcessor recordActionProcessor = recordProcessorFactory.getProcessorByTitle(actionTitle);
        recordActionProcessor.doAction();
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "add";
    }
}
