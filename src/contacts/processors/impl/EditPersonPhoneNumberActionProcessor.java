package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.IPersonActionProcessor;
import contacts.service.IRecordService;
import contacts.service.Validator;

import java.io.IOException;

public class EditPersonPhoneNumberActionProcessor implements IPersonActionProcessor {

    private final IRecordService recordService;

    public EditPersonPhoneNumberActionProcessor(IRecordService personService) {
        this.recordService = personService;
    }

    @Override
    public void doAction(Record record) throws IOException {
        boolean isPhoneNumberValid = false;
        String phoneNumber = ConsoleReader.getStringFromConsole("Enter the number");
        isPhoneNumberValid = Validator.validatePhoneNumber(phoneNumber);
        if (!isPhoneNumberValid) {
            System.out.println(Constants.WRONG_NUMBER_FORMAT);

            record.setPhoneNumber("[no number]");
            recordService.update(record);
        } else {
            record.setPhoneNumber(phoneNumber);
            recordService.update(record);
        }
        System.out.println("The record updated!");
        System.out.println();
    }

    @Override
    public String getSupportedActionTitle() {
        return "number";
    }
}
