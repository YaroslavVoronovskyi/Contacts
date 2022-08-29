package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Person;
import contacts.model.Record;
import contacts.processors.IRecordActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;
import java.time.LocalDateTime;

public class AddNewPersonActionProcessor implements IRecordActionProcessor {

    private final IRecordService recordService;

    public AddNewPersonActionProcessor(IRecordService personService) {
        this.recordService = personService;
    }

    @Override
    public void doAction() throws IOException {
        String name = ConsoleReader.getStringFromConsole("Enter the name of the person:");
        String surname = ConsoleReader.getStringFromConsole("Enter the surname of the person:");
        String birthDate = ConsoleReader.getStringFromConsole("Enter the birth date:");
        String gender = ConsoleReader.getStringFromConsole("Enter the gender (M, F):");
        System.out.println("Bad gender!");
        String number = ConsoleReader.getStringFromConsole("Enter the phone number:");

        Record record = new Person(name, surname, "[no data]", "[no data]");
        record.setPerson(true);
        record.setPhoneNumber(number);
        record.setCreationDate(LocalDateTime.now());
        record.setLastEditeDate(LocalDateTime.now());
        recordService.save(record);

        System.out.println("The record added.");
        System.out.println();
    }

    @Override
    public String getSupportedActionTitle() {
        return "person";
    }
}
