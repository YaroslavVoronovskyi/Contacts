package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Organization;
import contacts.processors.IOrganizationActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;

public class EditOrganizationAddressProcessor implements IOrganizationActionProcessor {

    private final IRecordService personService;

    public EditOrganizationAddressProcessor(IRecordService personService) {
        this.personService = personService;
    }

    @Override
    public void doActionOrganization(Organization organization) throws IOException {
        String address = ConsoleReader.getStringFromConsole("Enter address:");
        organization.setAddress(address);
        personService.update(organization);
        System.out.println("The record updated!");
        System.out.println();
        System.out.println(organization);
    }

    @Override
    public String getSupportedActionTitle() {
        return "address";
    }
}
