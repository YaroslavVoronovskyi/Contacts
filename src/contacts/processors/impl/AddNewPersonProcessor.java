package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Person;
import contacts.processors.IRecordActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;
import java.time.LocalDateTime;

public class AddNewPersonProcessor implements IRecordActionProcessor {

    private final IRecordService recordService;

    public AddNewPersonProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void doAction() throws IOException {
        String name = ConsoleReader.getStringFromConsole("Enter the name of the person:",
                Constants.NAME_CHECK_PATTERN, Constants.WRONG_NAME_FORMAT_ERROR);
        String surname = ConsoleReader.getStringFromConsole("Enter the surname of the person:",
                Constants.SURNAME_CHECK_PATTERN, Constants.WRONG_SURNAME_FORMAT_ERROR);
        String birthDate = ConsoleReader.getStringFromConsole("Enter birth date (format mm/dd/yyyy): ",
                Constants.BIRTH_DATE_CHECK_PATTERN, Constants.WRONG_BIRTH_DATE_FORMAT_ERROR);
        String gender = ConsoleReader.getStringFromConsole("Enter the gender (M, F):",
                Constants.GENDER_CHECK_PATTERN, Constants.WRONG_GENDER_ERROR);
        String number = ConsoleReader.getStringFromConsole("Enter the new phone number: ",
                Constants.PHONE_NUMBER_CHECK_PATTERN, Constants.WRONG_NUMBER_FORMAT_ERROR);
        Person person = new Person(name, surname);
        person.setGender(birthDate);
        person.setGender(gender);
        person.setPhoneNumber(number);
        person.setCreationDate(LocalDateTime.now());
        person.setLastEditDate(LocalDateTime.now());
        recordService.save(person);
        System.out.println("The record added.");
        System.out.println();
    }

    @Override
    public String getSupportedActionTitle() {
        return "person";
    }
}
