package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Record;
import contacts.processors.IActionProcessor;
import contacts.processors.IProcessorFactory;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchRecordProcessor implements IActionProcessor {

    private final IRecordService recordService;
    private final IProcessorFactory processorFactory;

    public SearchRecordProcessor(IRecordService recordService, IProcessorFactory processorFactory) {
        this.recordService = recordService;
        this.processorFactory = processorFactory;
    }

    @Override
    public boolean doAction() throws IOException {
        String query = ConsoleReader.getStringFromConsole("Enter search query: ");
        List<Record> resultsList = searchMatching(query);
        System.out.println("Found " + resultsList.size() + " results:");

        for (Record record : resultsList) {
            record.matcher(record);
        }
        int index = Integer.parseInt(ConsoleReader.getPersonData());
        index = index - 1;
        Record record = resultsList.get(index);
        String actionTitle = ConsoleReader.getPersonData();
        IActionProcessor processor = processorFactory.getProcessorByTitle(actionTitle);
        processor.doAction();
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "search";
    }

    private List<Record> searchMatching(String query) {
        List<Record> resultsList = new ArrayList<>();
        for (Record record : recordService.getAll()) {
            record.searchMatchingType(query, record, resultsList);
        }
        return resultsList;
    }
}
