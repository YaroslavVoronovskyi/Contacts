package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Person;
import contacts.model.Record;
import contacts.processors.IEditRecordActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;
import java.time.LocalDateTime;

public class EditSurnamePersonProcessor implements IEditRecordActionProcessor {

    private final IRecordService recordService;

    public EditSurnamePersonProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void doAction(Record record) throws IOException {
        Person person = (Person) record;
        String surname = ConsoleReader.getStringFromConsole("Enter the surname");
        person.setSurname(surname);
        person.setLastEditDate(LocalDateTime.now());
        recordService.update(person);
        System.out.println("The record updated!");
    }

    @Override
    public String getSupportedActionTitle() {
        return "surname";
    }
}
