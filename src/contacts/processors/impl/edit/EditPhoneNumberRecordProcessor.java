package contacts.processors.impl.edit;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.IEditRecordProcessor;
import contacts.service.IRecordService;

import java.time.LocalDateTime;

public class EditPhoneNumberRecordProcessor implements IEditRecordProcessor {

    private final IRecordService recordService;

    public EditPhoneNumberRecordProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void editRecord(Record record) {
        String phoneNumber = ConsoleReader.getStringFromConsole("Enter the new phone number: ",
                Constants.PHONE_NUMBER_CHECK_PATTERN, Constants.WRONG_NUMBER_FORMAT_ERROR);
        record.setPhoneNumber(phoneNumber);
        record.setLastEditDate(LocalDateTime.now());
        recordService.update(record);
        System.out.println("The record updated!");
        System.out.println();
    }

    @Override
    public String getSupportedFieldEditionName() {
        return "number";
    }
}
