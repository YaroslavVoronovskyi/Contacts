package contacts.processors.impl;

import contacts.processors.IActionProcessor;
import contacts.processors.ISearchProcessorFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProcessorFactorySearch implements ISearchProcessorFactory {

    private final Map<String, IActionProcessor> processorsMap;

    public ProcessorFactorySearch(List<IActionProcessor> actionProcessors) {
        processorsMap = actionProcessors.stream()
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
