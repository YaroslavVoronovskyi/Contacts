package contacts.processors.impl;

import contacts.ConsoleReader;
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
    public void doAction() throws IOException, ClassNotFoundException {
        String name = ConsoleReader.getStringFromConsole("Enter the name of the person:");
        String surname = ConsoleReader.getStringFromConsole("Enter the surname of the person:");
        String birthDate = ConsoleReader.getStringFromConsole("Enter the birth date:");
        String gender = ConsoleReader.getStringFromConsole("Enter the gender (M, F):");
        String number = Validator.getValidPhoneNumberFromConsole();
        Record record = new Person(name, surname, birthDate, gender);
        record.setPhoneNumber(number);
        record.setCreationDate(LocalDateTime.now());
        record.setLastEditDate(LocalDateTime.now());
        recordService.save(record);
        System.out.println("The record added.");
        System.out.println();
    }

    @Override
    public String getSupportedActionTitle() {
        return "person";
    }
}
