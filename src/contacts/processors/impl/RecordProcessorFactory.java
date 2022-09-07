package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.processors.IRecordActionProcessor;
import contacts.processors.IRecordProcessorFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RecordProcessorFactory implements IRecordProcessorFactory {

    private final Map<String, IRecordActionProcessor> processorsMap;

    public RecordProcessorFactory(List<IRecordActionProcessor> recordActionProcessorsList) {
        processorsMap = recordActionProcessorsList.stream()
                .collect(Collectors.toMap(IRecordActionProcessor::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public IRecordActionProcessor getProcessorByTitle(String title) throws IOException {
        boolean isTitleExist = false;
        IRecordActionProcessor processor = null;
        while (!isTitleExist) {
            isTitleExist = processorsMap.containsKey(title);
            processor = processorsMap.get(title);
            if (!isTitleExist) {
                System.out.println(Constants.WRONG_TITLE_ERROR);
                System.out.println("Enter the type (person, organization):");
                title = ConsoleReader.getStringFromConsole("Enter the correct title");
            }
        }
        return processor;
    }
}
