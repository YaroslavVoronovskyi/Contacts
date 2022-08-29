package contacts.processors.impl;

import contacts.processors.IActionProcessor;
import contacts.processors.IProcessorFactory;

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
    public IActionProcessor getProcessorByTitle(String title) {
        IActionProcessor processor = processorsMap.get(title);
        if (processor == null) {
            throw  new IllegalArgumentException("No processor found fot title " + title);
        }
        return processor;
    }
}
