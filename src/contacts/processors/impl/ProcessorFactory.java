package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.processors.IActionProcessor;
import contacts.processors.IProcessorFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProcessorFactory implements IProcessorFactory {

    private final Map<String, IActionProcessor> processorsMap;

    public ProcessorFactory(List<IActionProcessor> iActionProcessorsList) {
        processorsMap = iActionProcessorsList.stream()
                .collect(Collectors.toMap(IActionProcessor::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public IActionProcessor getProcessorByTitle(String title) throws IOException {
        boolean isTitleExist = false;
        IActionProcessor processor = null;

        while (!isTitleExist) {
            isTitleExist = processorsMap.containsKey(title);
            processor = processorsMap.get(title);
            if (!isTitleExist) {
                System.out.println(Constants.WRONG_TITLE_ERROR);
                System.out.println("[menu] Enter action processor (add, list, edit, remove, search, count, exit):");
                title = ConsoleReader.getStringFromConsole("Enter the correct title");
            }
        }
        return processor;
    }
}
