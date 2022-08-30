package contacts.processors.impl;

import contacts.processors.IOrganizationActionProcessor;
import contacts.processors.IEditOrganizationProcessorFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EditOrganizationProcessorFactory implements IEditOrganizationProcessorFactory {

    private final Map<String, IOrganizationActionProcessor> processorsMap;

    public EditOrganizationProcessorFactory(List<IOrganizationActionProcessor> iPersonActionProcessor) {
        processorsMap = iPersonActionProcessor.stream()
                .collect(Collectors.toMap(IOrganizationActionProcessor::getSupportedActionTitle, Function.identity()));
    }

    @Override
    public IOrganizationActionProcessor getProcessorByTitle(String title) {
        IOrganizationActionProcessor processor = processorsMap.get(title);
        if (processor == null) {
            throw  new IllegalArgumentException("No processor found fot title " + title);
        }
        return processor;
    }
}
