package contacts.processors.impl.add;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.processors.IAddRecordProcessor;
import contacts.processors.IAddRecordProcessorFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddRecordProcessorFactory implements IAddRecordProcessorFactory {

    private final Map<String, IAddRecordProcessor> processorsMap;

    public AddRecordProcessorFactory(List<IAddRecordProcessor> addRecordProcessorsList) {
        processorsMap = addRecordProcessorsList.stream()
                .collect(Collectors.toMap(IAddRecordProcessor::getSupportedRecordType, Function.identity()));
    }

    @Override
    public IAddRecordProcessor getProcessorByRecordType(String title) {
        IAddRecordProcessor processor = null;
        while (processor == null) {
            processor = processorsMap.get(title);
            if (processor == null) {
                System.out.println(Constants.WRONG_TITLE_ERROR);
                System.out.println("Enter the type (person, organization):");
                title = ConsoleReader.getStringFromConsole("Enter the correct title");
            }
        }
        return processor;
    }
}
