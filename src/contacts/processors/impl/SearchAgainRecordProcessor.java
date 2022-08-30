package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Record;
import contacts.processors.IActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchAgainRecordProcessor implements IActionProcessor {

    private final IRecordService recordService;

    public SearchAgainRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() throws IOException {
        String query = ConsoleReader.getStringFromConsole("Enter search query: ");
        List<Record> resultsList = searchMatching(query);
        System.out.println("Found " + resultsList.size() + " results:");
        for (Record record : resultsList) {
            record.matcher(record);
        }
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "again";
    }

    private List<Record> searchMatching(String query) {
        List<Record> resultsList = new ArrayList<>();
        for (Record record : recordService.getAll()) {
            record.searchMatchingType(query, record, resultsList);
        }
        return resultsList;
    }
}
