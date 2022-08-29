package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Organization;
import contacts.processors.IOrganizationActionProcessor;
import contacts.service.IRecordService;
import contacts.service.Validator;

import java.io.IOException;

public class EditOrganizationPhoneNumberActionProcessor implements IOrganizationActionProcessor {

    private final IRecordService personService;

    public EditOrganizationPhoneNumberActionProcessor(IRecordService personService) {
        this.personService = personService;
    }

    @Override
    public void doActionOrganization(Organization organization) throws IOException {
        boolean isPhoneNumberValid = false;
        String phoneNumber = ConsoleReader.getStringFromConsole("Enter the number");
        isPhoneNumberValid = Validator.validatePhoneNumber(phoneNumber);
        if (!isPhoneNumberValid) {
            System.out.println(Constants.WRONG_NUMBER_FORMAT);

            organization.setPhoneNumber("[no number]");
            personService.update(organization);
        } else {
            organization.setPhoneNumber(phoneNumber);
            personService.update(organization);
        }
        System.out.println("The record updated!");
        System.out.println();
    }

    @Override
    public String getSupportedActionTitle() {
        return "number";
    }
}
