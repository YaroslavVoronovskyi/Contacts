package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.model.Organization;
import contacts.model.Record;
import contacts.processors.*;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.List;

public class EditRecordProcessor implements IActionProcessor {
    private final IRecordService recordService;
    private final IEditPersonProcessorFactory processorFactoryEditPerson;
    private final IEditOrganizationProcessorFactory processorFactoryEditOrganization;

    public EditRecordProcessor(IRecordService recordService,
                               IEditPersonProcessorFactory processorFactoryEditPerson,
                               IEditOrganizationProcessorFactory processorFactoryEditOrganization) {
        this.recordService = recordService;
        this.processorFactoryEditPerson = processorFactoryEditPerson;
        this.processorFactoryEditOrganization = processorFactoryEditOrganization;
    }

    @Override
    public boolean doAction() throws IOException {
        List<Record> personsList = recordService.getAll();
        if (personsList.size() == 0) {
            System.out.println("No records to edit!");
            return false;
        }
        System.out.println();

        int index = 0;
        Record currentPerson = personsList.get(index);
        try {
            if (!currentPerson.isPerson()) {
                String actionTitleOrganization = ConsoleReader.getStringFromConsole("Select a field (address, number):");
                IOrganizationActionProcessor actionProcessorEditOrganization = processorFactoryEditOrganization.
                        getProcessorByTitle(actionTitleOrganization);
                actionProcessorEditOrganization.doOrganizationAction((Organization) personsList.get(index));

            } else {
                String actionTitle = ConsoleReader.getStringFromConsole("Select a field (name, surname, birth, gender, number): ");
                IPersonActionProcessor actionProcessorEditPersonName = processorFactoryEditPerson
                        .getProcessorByTitle(actionTitle);
                actionProcessorEditPersonName.doAction(currentPerson);
                System.out.println();
            }
        } catch (NumberFormatException exception) {
            System.out.println(exception.getStackTrace());
        }
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "edit";
    }
}
