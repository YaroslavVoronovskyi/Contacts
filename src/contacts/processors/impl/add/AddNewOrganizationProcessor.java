package contacts.processors.impl.add;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Organization;
import contacts.processors.IAddRecordProcessor;
import contacts.service.IRecordService;

import java.time.LocalDateTime;

public class AddNewOrganizationProcessor implements IAddRecordProcessor {

    private final IRecordService recordService;

    public AddNewOrganizationProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void addNewRecord() {
        String name = ConsoleReader.getStringFromConsole("Enter the name of the organization: ",
                Constants.NAME_CHECK_PATTERN, Constants.WRONG_NAME_FORMAT_ERROR);
        String address = ConsoleReader.getStringFromConsole("Enter the address: ",
                Constants.ADDRESS_CHECK_PATTERN, Constants.WRONG_ADDRESS_FORMAT_ERROR);
        Organization organization = new Organization(name, address);
        String number = ConsoleReader.getStringFromConsole("Enter the new phone number: ",
                Constants.PHONE_NUMBER_CHECK_PATTERN, Constants.WRONG_NUMBER_FORMAT_ERROR);
        organization.setPhoneNumber(number);
        organization.setCreationDate(LocalDateTime.now());
        organization.setLastEditDate(LocalDateTime.now());
        recordService.save(organization);
        System.out.println("The record added.");
        System.out.println();
    }

    @Override
    public String getSupportedRecordType() {
        return "organization";
    }
}
