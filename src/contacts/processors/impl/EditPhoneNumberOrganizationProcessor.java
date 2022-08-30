package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Organization;
import contacts.processors.IOrganizationActionProcessor;
import contacts.service.IRecordService;
import contacts.service.Validator;

import java.io.IOException;

public class EditPhoneNumberOrganizationProcessor implements IOrganizationActionProcessor {

    private final IRecordService recordService;

    public EditPhoneNumberOrganizationProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void doOrganizationAction(Organization organization) throws IOException {
        boolean isPhoneNumberValid = false;
        String phoneNumber = ConsoleReader.getStringFromConsole("Enter the number");
        isPhoneNumberValid = Validator.validatePhoneNumber(phoneNumber);
        if (!isPhoneNumberValid) {
            System.out.println(Constants.WRONG_NUMBER_FORMAT_ERROR);
            organization.setPhoneNumber("[no number]");
        } else {
            organization.setPhoneNumber(phoneNumber);
        }
        recordService.update(organization);
        System.out.println("The record updated!");
        System.out.println();
    }

    @Override
    public String getSupportedActionTitle() {
        return "number";
    }
}
