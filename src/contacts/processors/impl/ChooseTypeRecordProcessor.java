package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.processors.IActionProcessor;
import contacts.processors.IRecordActionProcessor;
import contacts.processors.IRecordProcessorFactory;

import java.io.IOException;

public class ChooseTypeRecordProcessor implements IActionProcessor {
    private final IRecordProcessorFactory recordProcessorFactory;

    public ChooseTypeRecordProcessor(IRecordProcessorFactory recordProcessorFactory) {
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
