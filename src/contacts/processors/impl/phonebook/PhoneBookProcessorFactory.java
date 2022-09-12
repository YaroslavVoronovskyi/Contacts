package contacts.processors.impl.phonebook;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.processors.IPhoneBookActionProcessor;
import contacts.processors.IPhoneBookProcessorFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PhoneBookProcessorFactory implements IPhoneBookProcessorFactory {

    private final Map<String, IPhoneBookActionProcessor> processorsMap;

    public PhoneBookProcessorFactory(List<IPhoneBookActionProcessor> phoneBookActionProcessorsList) {
        processorsMap = phoneBookActionProcessorsList.stream()
                .collect(Collectors.toMap(IPhoneBookActionProcessor::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public IPhoneBookActionProcessor getProcessorByAction(String title) {
        IPhoneBookActionProcessor phoneBookActionProcessor = null;
        while (phoneBookActionProcessor == null) {
            phoneBookActionProcessor = processorsMap.get(title);
            if (phoneBookActionProcessor == null) {
                System.out.println(Constants.WRONG_TITLE_ERROR);
                System.out.println("[menu] Enter action processor (add, list, edit, remove, search, count, exit):");
                title = ConsoleReader.getStringFromConsole("Enter the correct title");
            }
        }
        return phoneBookActionProcessor;
    }
}
