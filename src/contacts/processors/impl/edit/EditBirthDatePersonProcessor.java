package contacts.processors.impl.edit;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Person;
import contacts.model.Record;
import contacts.processors.IEditRecordProcessor;
import contacts.service.IRecordService;

public class EditBirthDatePersonProcessor implements IEditRecordProcessor {

    private final IRecordService recordService;

    public EditBirthDatePersonProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void editRecord(Record record) {
        Person person = (Person) record;
        String birthDate = ConsoleReader.getStringFromConsole("Enter birth date: mm/dd/yyyy",
                Constants.BIRTH_DATE_CHECK_PATTERN, Constants.WRONG_BIRTH_DATE_FORMAT_ERROR);
        person.setBirthDate(birthDate);
        recordService.update(person);
        System.out.println("The record updated!");
    }

    @Override
    public String getSupportedFieldEditionName() {
        return "birth";
    }
}
