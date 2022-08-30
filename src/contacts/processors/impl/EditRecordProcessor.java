package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
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
        List<Record> recordsList = recordService.getAll();
        if (recordsList.size() == 0) {
            System.out.println("No records to edit!");
            return false;
        }
        int index = 0;
        for (Record record : recordsList) {
            index++;
            System.out.println(index + Constants.DOT_SEPARATOR + Constants.DELIMETER + record.getName());
        }
        System.out.println();
        int recordNumber = ConsoleReader.getIntFromConsole("Select a record: ");
        Record currentRecord = recordsList.get(recordNumber - 1);
        try {
            if (!currentRecord.isPerson()) {
                String actionTitleOrganization = ConsoleReader.getStringFromConsole("Select a field (address, number):");
                IOrganizationActionProcessor actionProcessorEditOrganization = processorFactoryEditOrganization.
                        getProcessorByTitle(actionTitleOrganization);
                actionProcessorEditOrganization.doOrganizationAction((Organization) recordsList.get(recordNumber -1));

            } else {
                String actionTitle = ConsoleReader.getStringFromConsole("Select a field (name, surname, birth, gender, number): ");
                IPersonActionProcessor actionProcessorEditPersonName = processorFactoryEditPerson
                        .getProcessorByTitle(actionTitle);
                actionProcessorEditPersonName.doAction(currentRecord);
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
