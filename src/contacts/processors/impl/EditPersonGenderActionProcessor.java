package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Person;
import contacts.model.Record;
import contacts.processors.IPersonActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;

public class EditPersonGenderActionProcessor implements IPersonActionProcessor {

    private final IRecordService recordService;

    public EditPersonGenderActionProcessor(IRecordService personService) {
        this.recordService = personService;
    }

    @Override
    public void doAction(Record record) throws IOException {
        Person person = (Person) record;
        String gender = ConsoleReader.getPersonData();
        person.setGender(gender);
        recordService.update(person);
        System.out.println(person);
    }

    @Override
    public String getSupportedActionTitle() {
        return "gender";
    }
}
