package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Person;
import contacts.model.Record;
import contacts.processors.IRecordActionProcessor;
import contacts.service.IRecordService;
import contacts.service.Validator;

import java.io.IOException;
import java.time.LocalDateTime;

public class AddNewPersonProcessor implements IRecordActionProcessor {

    private final IRecordService recordService;

    public AddNewPersonProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void doAction() throws IOException {
        boolean isPhoneNumberValid = false;
        String name = ConsoleReader.getStringFromConsole("Enter the name of the person:");
        String surname = ConsoleReader.getStringFromConsole("Enter the surname of the person:");
        String birthDate = ConsoleReader.getStringFromConsole("Enter the birth date:");
        String gender = ConsoleReader.getStringFromConsole("Enter the gender (M, F):");
        System.out.println("Bad gender!");
        while (!isPhoneNumberValid) {
            String number = ConsoleReader.getStringFromConsole("Enter the phone number:");
            isPhoneNumberValid = Validator.validatePhoneNumber(number);
            if (!isPhoneNumberValid) {
                System.out.println(Constants.WRONG_NUMBER_FORMAT_ERROR);
                continue;
            }
            Record record = new Person(name, surname, "[no data]", "[no data]");
            record.setPhoneNumber(number);
            record.setCreationDate(LocalDateTime.now());
            record.setLastEditDate(LocalDateTime.now());
            record.setPerson(true);
            recordService.save(record);

            System.out.println("The record added.");
            System.out.println();
        }
    }

    @Override
    public String getSupportedActionTitle() {
        return "person";
    }
}
