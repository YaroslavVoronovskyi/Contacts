package contacts;

import contacts.processors.IActionProcessor;
import contacts.processors.IProcessorFactory;

import java.io.IOException;

public class PhoneBook {
    private final IProcessorFactory processorFactory;

    public PhoneBook(IProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    public void runPhoneBook() throws IOException, ClassNotFoundException {
        boolean needContinue = true;
        while (needContinue) {
            String actionTitle = ConsoleReader.getStringFromConsole("[menu] Enter action (add, list, search, count, exit):");
            IActionProcessor processor = processorFactory.getProcessorByTitle(actionTitle);
            needContinue = processor.doAction();
        }
    }
}
