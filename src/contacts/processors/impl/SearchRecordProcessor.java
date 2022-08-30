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
        int index = 0;
        for (Record record : resultsList) {
            index++;
            record.printListRecord(index);

        }
        int recordNumber = ConsoleReader.getIntFromConsole("Select a record: ");
        Record record = resultsList.get(recordNumber - 1);
        System.out.println(record);

        String actionTitle = ConsoleReader.getStringFromConsole();
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
            if (record.matches(query)) {
                resultsList.add(record);
            }
        }
        return resultsList;
    }
}
