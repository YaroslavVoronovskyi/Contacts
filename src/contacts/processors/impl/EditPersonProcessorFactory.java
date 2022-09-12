package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.processors.IEditRecordActionProcessor;
import contacts.processors.IEditRecordProcessorFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EditPersonProcessorFactory implements IEditRecordProcessorFactory {

    private final Map<String, IEditRecordActionProcessor> processorsMap;

    public EditPersonProcessorFactory(List<IEditRecordActionProcessor> iPersonActionProcessor) {
        processorsMap = iPersonActionProcessor.stream()
                .collect(Collectors.toMap(IEditRecordActionProcessor::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public IEditRecordActionProcessor getProcessorByTitle(String title) throws IOException {
        boolean isTitleExist = false;
        IEditRecordActionProcessor processor = null;
        while (!isTitleExist) {
            isTitleExist = processorsMap.containsKey(title);
            processor = processorsMap.get(title);
            if (!isTitleExist) {
                System.out.println(Constants.WRONG_TITLE_ERROR);
                title = ConsoleReader.getStringFromConsole("Enter the correct title");
            }
        }
        return processor;
    }
}
