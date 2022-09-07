package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Record;
import contacts.processors.IActionProcessor;
import contacts.processors.IProcessorFactory;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.List;

public class SearchPhoneNumberRecordProcessor implements IActionProcessor {
    private final IRecordService recordService;

    public SearchPhoneNumberRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() throws IOException {
        String query = ConsoleReader.getStringFromConsole("Enter search query: ");
        List<Record> resultsList = recordService.getRecordsByQuery(query);
        System.out.println("Found " + resultsList.size() + " results:");
        if (resultsList.size() == 0) {
            return true;
        }

        int index = 0;
        for (Record record : resultsList) {
            index++;
            record.printRecord(index);
        }
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "number";
    }
}
