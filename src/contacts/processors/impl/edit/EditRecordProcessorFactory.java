package contacts.processors.impl.edit;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.processors.IEditRecordProcessor;
import contacts.processors.IEditRecordProcessorFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EditRecordProcessorFactory implements IEditRecordProcessorFactory {

    private final Map<String, IEditRecordProcessor> processorsMap;

    public EditRecordProcessorFactory(List<IEditRecordProcessor> editRecordProcessorsList) {
        processorsMap = editRecordProcessorsList.stream()
                .collect(Collectors.toMap(IEditRecordProcessor::getSupportedFieldEditionName, Function.identity()));
    }

    @Override
    public IEditRecordProcessor getProcessorByFieldName(String title) {
        IEditRecordProcessor editRecordProcessor = null;
        while (editRecordProcessor == null) {
            editRecordProcessor = processorsMap.get(title);
            if (editRecordProcessor == null) {
                System.out.println(Constants.WRONG_TITLE_ERROR);
                title = ConsoleReader.getStringFromConsole("Enter the correct title");
            }
        }
        return editRecordProcessor;
    }
}
