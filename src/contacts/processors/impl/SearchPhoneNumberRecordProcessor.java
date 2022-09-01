package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Record;
import contacts.processors.IActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchPhoneNumberRecordProcessor implements IActionProcessor {
    private final IRecordService recordService;

    public SearchPhoneNumberRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
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
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "number";
    }

    private List<Record> searchMatching(String query) {
        List<Record> resultsList = new ArrayList<>();
        for (Record record : recordService.getAll()) {
            if (record.chooseRecordForEdit(query)) {
                resultsList.add(record);
            }
        }
        return resultsList;
    }
}
