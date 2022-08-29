package contacts.processors.impl;

import contacts.processors.IRecordActionProcessor;
import contacts.processors.IRecordProcessorFactory;

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
    public IRecordActionProcessor getProcessorByTitle(String title) {
        IRecordActionProcessor processor = processorsMap.get(title);
        if (processor == null) {
            throw  new IllegalArgumentException("No processor found fot title " + title);
        }
        return processor;
    }
}
