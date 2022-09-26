package contacts.processors.impl.edit;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Person;
import contacts.model.Record;
import contacts.processors.IEditRecordProcessor;
import contacts.service.IRecordService;

import java.time.LocalDateTime;

public class EditSurnamePersonProcessor implements IEditRecordProcessor {

    private final IRecordService recordService;

    public EditSurnamePersonProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void editRecord(Record record) {
        Person person = (Person) record;
        String surname = ConsoleReader.getStringFromConsole("Enter the surname of the person:",
                Constants.SURNAME_CHECK_PATTERN, Constants.WRONG_SURNAME_FORMAT_ERROR);
        person.setSurname(surname);
        person.setLastEditDate(LocalDateTime.now());
        recordService.update(person);
        System.out.println("The record updated!");
    }

    @Override
    public String getSupportedFieldEditionName() {
        return "surname";
    }
}
