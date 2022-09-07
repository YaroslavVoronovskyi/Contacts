package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.IEditRecordActionProcessor;
import contacts.service.IRecordService;
import contacts.service.Validator;

import java.io.IOException;
import java.time.LocalDateTime;

public class EditPhoneNumberRecordProcessor implements IEditRecordActionProcessor {

    private final IRecordService recordService;

    public EditPhoneNumberRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void doAction(Record record) throws IOException {
        String phoneNumber = ConsoleReader.getStringFromConsole("Enter the new phone number: ",
                Constants.PHONE_NUMBER_CHECK_PATTERN, Constants.WRONG_NUMBER_FORMAT_ERROR);
        record.setPhoneNumber(phoneNumber);
        record.setLastEditDate(LocalDateTime.now());
        recordService.update(record);
        System.out.println("The record updated!");
        System.out.println();
    }

    @Override
    public String getSupportedActionTitle() {
        return "number";
    }
}
