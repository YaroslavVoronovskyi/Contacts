package contacts;


import contacts.processors.*;
import contacts.processors.impl.*;
import contacts.service.IRecordService;
import contacts.service.RecordServiceImpl;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class ApplicationContacts {
    public static void main(String[] args) {
        try {
            IRecordService recordService = new RecordServiceImpl();

            IOrganizationActionProcessor editAddressOrganizationProcessor = new EditAddressOrganizationProcessor(recordService);
            IOrganizationActionProcessor editPhoneNumberOrganizationProcessor = new EditPhoneNumberOrganizationProcessor(recordService);
            IEditOrganizationProcessorFactory editOrganizationProcessorFactory = new EditOrganizationProcessorFactory(
                    List.of(editAddressOrganizationProcessor, editPhoneNumberOrganizationProcessor));

            IRecordActionProcessor addNewPersonProcessor = new AddNewPersonProcessor(recordService);
            IRecordActionProcessor addNewOrganizationProcessor = new AddNewOrganizationProcessor(recordService);

            IRecordProcessorFactory recordProcessorFactory = new RecordProcessorFactory(
                    List.of(addNewPersonProcessor, addNewOrganizationProcessor));

            IPersonActionProcessor editNamePersonProcessor = new EditNamePersonProcessor(recordService);
            IPersonActionProcessor editSurnamePersonProcessor = new EditSurnamePersonProcessor(recordService);
            IPersonActionProcessor editPhoneNumberPersonProcessor = new EditPhoneNumberPersonProcessor(recordService);
            IPersonActionProcessor editGenderPersonProcessor = new EditGenderPersonProcessor(recordService);

            IEditPersonProcessorFactory editPersonProcessorFactory = new EditPersonProcessorFactory(
                    List.of(editNamePersonProcessor, editSurnamePersonProcessor,
                            editPhoneNumberPersonProcessor, editGenderPersonProcessor));

            IActionProcessor chooseTypeRecordProcessor = new ChooseTypeRecordProcessor(recordService, recordProcessorFactory);

            IActionProcessor countRecordProcessor = new CountRecordProcessor(recordService);

            IActionProcessor searchPhoneNumberRecordProcessor = new SearchPhoneNumberRecordProcessor(recordService);
            IActionProcessor searchBackRecordProcessor = new SearchBackRecordProcessor();
            IActionProcessor searchAgainRecordProcessor = new SearchAgainRecordProcessor(recordService);
            ISearchRecordProcessorFactory searchRecordProcessorFactory = new SearchRecordProcessorFactory(
                    List.of(searchPhoneNumberRecordProcessor, searchBackRecordProcessor, searchAgainRecordProcessor));

            IActionProcessor editRecordProcessor = new EditRecordProcessor(recordService,
                    editPersonProcessorFactory, editOrganizationProcessorFactory);
            IActionProcessor removeRecordProcessor = new RemoveRecordProcessor(recordService);
            IActionProcessor exitApplicationProcessor = new ExitAppActionProcessor();

            IActionProcessor menuApplicationProcessor = new MenuApplicationProcessor();

            IProcessorFactory processorFactory = new ProcessorFactory(List.of(countRecordProcessor,
                    editRecordProcessor, removeRecordProcessor, exitApplicationProcessor, chooseTypeRecordProcessor, menuApplicationProcessor));

            IActionProcessor searchRecordProcessor = new SearchRecordProcessor(recordService, processorFactory);

            IActionProcessor listRecordProcessor = new ListRecordProcessor(recordService);
            processorFactory = new ProcessorFactory(List.of(countRecordProcessor, editRecordProcessor,
                    removeRecordProcessor, exitApplicationProcessor, chooseTypeRecordProcessor, listRecordProcessor,
                    menuApplicationProcessor, searchRecordProcessor));

            PhoneBook phoneBook = new PhoneBook(processorFactory);
            phoneBook.runPhoneBook();
        } catch (NumberFormatException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
