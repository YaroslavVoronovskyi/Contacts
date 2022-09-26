package contacts.processors.impl.edit;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Organization;
import contacts.model.Record;
import contacts.processors.IEditRecordProcessor;
import contacts.service.IRecordService;

import java.time.LocalDateTime;

public class EditAddressOrganizationProcessor implements IEditRecordProcessor {

    private final IRecordService recordService;

    public EditAddressOrganizationProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void editRecord(Record record) {
        Organization organization = (Organization) record;
        String address = ConsoleReader.getStringFromConsole("Enter the address:",
                Constants.ADDRESS_CHECK_PATTERN, Constants.WRONG_ADDRESS_FORMAT_ERROR);
        organization.setAddress(address);
        organization.setLastEditDate(LocalDateTime.now());
        recordService.update(organization);
        System.out.println("The record updated!");
        System.out.println();
        System.out.println(organization);
    }

    @Override
    public String getSupportedFieldEditionName() {
        return "address";
    }
}
