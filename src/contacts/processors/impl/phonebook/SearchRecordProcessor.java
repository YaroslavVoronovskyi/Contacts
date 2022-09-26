package contacts.processors.impl.phonebook;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.IPhoneBookActionProcessor;
import contacts.service.IRecordService;

import java.util.List;

public class SearchRecordProcessor implements IPhoneBookActionProcessor {

    private final IRecordService recordService;

    public SearchRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() {
        String query = ConsoleReader.getStringFromConsole("Enter search query: ",
                Constants.SEARCH_QUERY_CHECK_PATTERN, Constants.WRONG_SEARCH_QUERY_FORMAT_ERROR);
        List<Record> resultList = recordService.getRecordsByQuery(query);
        System.out.println("Found " + resultList.size() + " results:");
        if (resultList.size() == 0) {
            System.out.println("No records to show!");
            return true;
        }
        int index = 0;
        for (Record record : resultList) {
            index++;
            System.out.println(index + Constants.DOT_SEPARATOR + Constants.DELIMETER + record.getName());
        }

        int recordNumber = ConsoleReader.getIntFromConsole("Select a record: ", index);
        System.out.println(resultList.get(recordNumber - 1));
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "search";
    }
}
