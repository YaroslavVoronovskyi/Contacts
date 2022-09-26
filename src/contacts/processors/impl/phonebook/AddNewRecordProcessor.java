package contacts.processors.impl.phonebook;

import contacts.ConsoleReader;
import contacts.processors.IPhoneBookActionProcessor;
import contacts.processors.IAddRecordProcessor;
import contacts.processors.IAddRecordProcessorFactory;

public class AddNewRecordProcessor implements IPhoneBookActionProcessor {
    private final IAddRecordProcessorFactory addRecordProcessorFactory;

    public AddNewRecordProcessor(IAddRecordProcessorFactory addRecordProcessorFactory) {
        this.addRecordProcessorFactory = addRecordProcessorFactory;
    }

    @Override
    public boolean doAction() {
        String recordType = ConsoleReader.getStringFromConsole("Enter the type (person, organization):");
        IAddRecordProcessor addRecordProcessor = addRecordProcessorFactory.getProcessorByRecordType(recordType);
        addRecordProcessor.addNewRecord();
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "add";
    }
}
