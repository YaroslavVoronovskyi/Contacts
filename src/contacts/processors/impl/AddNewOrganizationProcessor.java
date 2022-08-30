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

public class AddNewOrganizationProcessor implements IRecordActionProcessor {

    private final IRecordService recordService;

    public AddNewOrganizationProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void doAction() throws IOException {
        boolean isPhoneNumberValid = false;
        String name = ConsoleReader.getStringFromConsole("Enter the organization name:");
        String address = ConsoleReader.getStringFromConsole("Enter the address:");
        Record record = new Organization(name, address);

        while (!isPhoneNumberValid) {
            String number = ConsoleReader.getStringFromConsole("Enter the phone number:");
            isPhoneNumberValid = Validator.validatePhoneNumber(number);
            if (isPhoneNumberValid) {
                System.out.println(Constants.WRONG_NUMBER_FORMAT_ERROR);
                continue;
            }
            record.setPhoneNumber(number);
            record.setCreationDate(LocalDateTime.now());
            record.setLastEditDate(LocalDateTime.now());
            recordService.save(record);
            System.out.println("The record added.");
            System.out.println();
        }
    }

    @Override
    public String getSupportedActionTitle() {
        return "organization";
    }
}
