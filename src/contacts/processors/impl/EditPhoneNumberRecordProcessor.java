package contacts.processors.impl;

import contacts.model.Record;
import contacts.processors.IEditRecordActionProcessor;
import contacts.service.IRecordService;
import contacts.service.Validator;

import java.io.IOException;

public class EditPhoneNumberRecordProcessor implements IEditRecordActionProcessor {

    private final IRecordService recordService;

    public EditPhoneNumberRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void doAction(Record record) throws IOException, ClassNotFoundException {
        String phoneNumber = Validator.getValidPhoneNumberFromConsole();
        record.setPhoneNumber(phoneNumber);
        recordService.update(record);
        System.out.println("The record updated!");
        System.out.println();
    }

    @Override
    public String getSupportedActionTitle() {
        return "number";
    }
}
