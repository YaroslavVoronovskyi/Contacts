package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Organization;
import contacts.model.Person;
import contacts.model.Record;
import contacts.processors.IActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchActionProcessorNumber implements IActionProcessor {
    private final IRecordService recordService;

    public SearchActionProcessorNumber(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() throws IOException {
        String query = ConsoleReader.getPersonData();
        int index = 1;
        List<Record> resultsList = searchMatching(query);
        for (Record record : resultsList) {
            if (record instanceof Person person) {
                System.out.println(index + ". " + person.getName() + " " + person.getSurname());
                index += 1;
            } else if (record instanceof Organization organization) {
                System.out.println(index + ". " + organization.getName());
                index += 1;
            }
        }
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "number";
    }

    private List<Record> searchMatching(String query) {
        List<Record> resultsList = new ArrayList<>();
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        for (Record record : recordService.getAll()) {
            if (record instanceof Person person) {
                String find = person.getName() + Constants.DELIMETER + person.getPhoneNumber();
                Matcher matcher = pattern.matcher(find);
                if (matcher.find()) {
                    resultsList.add(person);
                }
            } else if (record instanceof Organization organization) {
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
