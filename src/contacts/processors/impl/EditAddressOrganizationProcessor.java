package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Organization;
import contacts.processors.IOrganizationActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;

public class EditAddressOrganizationProcessor implements IOrganizationActionProcessor {

    private final IRecordService recordService;

    public EditAddressOrganizationProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void doOrganizationAction(Organization organization) throws IOException {
        String address = ConsoleReader.getStringFromConsole("Enter address:");
        organization.setAddress(address);
        recordService.update(organization);
        System.out.println("The record updated!");
        System.out.println();
        System.out.println(organization);
    }

    @Override
    public String getSupportedActionTitle() {
        return "address";
    }
}
