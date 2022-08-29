package contacts;

import contacts.processors.IActionProcessor;
import contacts.processors.IProcessorFactory;

import java.io.IOException;

public class PhoneBook {
    private final IProcessorFactory processorFactory;

    public PhoneBook(IProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    public void runPhoneBook() throws IOException {
        while (true) {
            String actionTitle = ConsoleReader.getStringFromConsole("Enter action (add, remove, edit, count, list, exit):");
            if (actionTitle.equals("exit")) {
                break;
            }
            IActionProcessor processor = processorFactory.getProcessorByTitle(actionTitle);
            processor.doAction();
        }
    }
}
