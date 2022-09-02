package contacts.processors.impl;

import contacts.processors.IEditRecordActionProcessor;
import contacts.processors.IEditRecordProcessorFactory;

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
    public IEditRecordActionProcessor getProcessorByTitle(String title) {
        IEditRecordActionProcessor processor = processorsMap.get(title);
        if (processor == null) {
            throw  new IllegalArgumentException("No processor found fot title " + title);
        }
        return processor;
    }
}
