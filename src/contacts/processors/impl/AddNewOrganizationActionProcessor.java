package contacts.processors.impl;


import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Organization;
import contacts.model.Record;
import contacts.processors.IRecordActionProcessor;
import contacts.service.IRecordService;
import contacts.service.Validator;

import java.io.IOException;
import java.time.LocalDateTime;

public class AddNewOrganizationActionProcessor implements IRecordActionProcessor {

    private final IRecordService personService;

    public AddNewOrganizationActionProcessor(IRecordService personService) {

        this.personService = personService;
    }

    @Override
    public void doAction() throws IOException {
        boolean isPhoneNumberValid = false;
        String name = ConsoleReader.getStringFromConsole("Enter the organization name:");
        String address = ConsoleReader.getStringFromConsole("Enter the address:");
        String number = ConsoleReader.getStringFromConsole("Enter the phone number:");
        isPhoneNumberValid = Validator.validatePhoneNumber(number);

        Record record = new Organization(name, address);
        record.setPerson(false);

        if (!isPhoneNumberValid) {
            System.out.println(Constants.WRONG_NUMBER_FORMAT);

            record.setPhoneNumber("[no number]");
            record.setCreationDate(LocalDateTime.now());
            record.setLastEditeDate(LocalDateTime.now());
            personService.save(record);
        } else {
            record.setPhoneNumber(number);
            record.setCreationDate(LocalDateTime.now());
            record.setLastEditeDate(LocalDateTime.now());
            personService.save(record);
        }

        System.out.println("The record added.");
        System.out.println();
    }
    //  }

    @Override
    public String getSupportedActionTitle() {
        return "organization";
    }
}
