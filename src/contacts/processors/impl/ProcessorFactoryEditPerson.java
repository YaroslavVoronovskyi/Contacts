package contacts.processors.impl;

import contacts.processors.IPersonActionProcessor;
import contacts.processors.IPersonEditProcessorFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProcessorFactoryEditPerson implements IPersonEditProcessorFactory {

    private final Map<String, IPersonActionProcessor> processorsMap;

    public ProcessorFactoryEditPerson(List<IPersonActionProcessor> iPersonActionProcessor) {
        processorsMap = iPersonActionProcessor.stream()
                .collect(Collectors.toMap(IPersonActionProcessor::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public IPersonActionProcessor getProcessorByTitle(String title) {
        IPersonActionProcessor processor = processorsMap.get(title);
        if (processor == null) {
            throw  new IllegalArgumentException("No processor found fot title " + title);
        }
        return processor;
    }
}
