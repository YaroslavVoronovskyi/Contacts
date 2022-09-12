package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Person;
import contacts.model.Record;
import contacts.processors.IEditRecordActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;
import java.time.LocalDateTime;

public class EditGenderPersonProcessor implements IEditRecordActionProcessor {

    private final IRecordService recordService;

    public EditGenderPersonProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void doAction(Record record) throws IOException {
        Person person = (Person) record;
        String gender = ConsoleReader.getStringFromConsole("Enter the gender (M, F):",
                Constants.GENDER_CHECK_PATTERN, Constants.WRONG_GENDER_ERROR);
        person.setGender(gender);
        person.setLastEditDate(LocalDateTime.now());
        recordService.update(person);
        System.out.println(person);
    }

    @Override
    public String getSupportedActionTitle() {
        return "gender";
    }
}
