package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Organization;
import contacts.model.Person;
import contacts.model.Record;
import contacts.processors.IActionProcessor;
import contacts.processors.IProcessorFactory;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        int index = 1;
        System.out.println("Found " + resultsList.size() + " results:");

        for (Record record : resultsList) {
            if (record instanceof Person) {
                Person person = (Person) record;
                System.out.println(index + ". " + person.getName() + Constants.DELIMETER + person.getSurname());
                index += 1;
            } else if (record instanceof Organization) {
                Organization organization = (Organization) record;
                System.out.println(index + ". " + organization.getName());
                index += 1;
            }
        }
        int index1 = Integer.parseInt(ConsoleReader.getPersonData());
        index1 = index1 - 1;

        Record record = resultsList.get(index1);
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
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        for (Record record : recordService.getAll()) {
            if (record instanceof Person) {
                Person person = (Person) record;
                String find = person.getName() + Constants.DELIMETER + person.getSurname() + Constants.DELIMETER + person.getPhoneNumber();
                Matcher matcher = pattern.matcher(find);
                if (matcher.find()) {
                    resultsList.add(person);
                }
            } else if (record instanceof Organization) {
                Organization organization = (Organization) record;
                String find = organization.getName() + Constants.DELIMETER + organization.getPhoneNumber();
                Matcher matcher = pattern.matcher(find);
                if (matcher.find()) {
                    resultsList.add(organization);
                }
            }
        }
        return resultsList;
    }
}
