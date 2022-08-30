package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.processors.IActionProcessor;
import contacts.processors.IRecordActionProcessor;
import contacts.processors.IRecordProcessorFactory;
import contacts.service.IRecordService;

import java.io.IOException;

public class ChooseTypeRecordProcessor implements IActionProcessor {

    private final IRecordService recordService;
    private final IRecordProcessorFactory recordProcessorFactory;

    public ChooseTypeRecordProcessor(IRecordService recordService, IRecordProcessorFactory recordProcessorFactory) {
        this.recordService = recordService;
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
