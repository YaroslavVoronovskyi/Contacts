package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Person;
import contacts.model.Record;
import contacts.processors.IPersonActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;

public class EditPersonSurnameActionProcessor implements IPersonActionProcessor {

    private final IRecordService recordService;

    public EditPersonSurnameActionProcessor(IRecordService personService) {
        this.recordService = personService;
    }

    @Override
    public void doAction(Record record) throws IOException {
        Person person = (Person) record;
        String surname = ConsoleReader.getStringFromConsole("Enter the surname");
        person.setSurname(surname);
        recordService.update(person);
        System.out.println("The record updated!");
    }

    @Override
    public String getSupportedActionTitle() {
        return "surname";
    }
}
