package contacts;

import contacts.processors.IPhoneBookActionProcessor;
import contacts.processors.IPhoneBookProcessorFactory;

public class PhoneBook {

    private final IPhoneBookProcessorFactory processorFactory;

    public PhoneBook(IPhoneBookProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    public void runPhoneBook() {
        try {
            boolean needContinue = true;
            while (needContinue) {
                String actionTitle = ConsoleReader.getStringFromConsole("[menu] Enter action processor (add, list, edit, remove, search, count, exit):");
                IPhoneBookActionProcessor processor = processorFactory.getProcessorByAction(actionTitle);
                needContinue = processor.doAction();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
