package contacts;


import contacts.processors.*;
import contacts.processors.impl.*;
import contacts.service.IRecordService;
import contacts.service.RecordServiceImpl;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            IRecordService recordService = new RecordServiceImpl();

            IOrganizationActionProcessor actionProcessorEditAddressOrganization = new EditOrganizationAddressProcessor(recordService);
            IOrganizationActionProcessor actionProcessorEditPhoneNumberOrganization = new EditOrganizationPhoneNumberActionProcessor(recordService);
            IOrganizationEditProcessorFactory organizationEditProcessorFactory = new ProcessorFactoryEditOrganization(
                    List.of(actionProcessorEditAddressOrganization, actionProcessorEditPhoneNumberOrganization));

            IRecordActionProcessor actionProcessorAddPerson = new AddNewPersonActionProcessor(recordService);
            IRecordActionProcessor actionProcessorAddOrganization = new AddNewOrganizationActionProcessor(recordService);

            IRecordProcessorFactory recordProcessorFactory = new RecordProcessorFactory(
                    List.of(actionProcessorAddPerson, actionProcessorAddOrganization));

            IPersonActionProcessor actionProcessorEditPersonName = new EditPersonNameActionProcessor(recordService);
            IPersonActionProcessor actionProcessorEditPersonSurname = new EditPersonSurnameActionProcessor(recordService);
            IPersonActionProcessor actionProcessorEditPersonPhoneNumber = new EditPersonPhoneNumberActionProcessor(recordService);
            IPersonActionProcessor actionProcessorEditPersonGender = new EditPersonGenderActionProcessor(recordService);

            IPersonEditProcessorFactory processorFactoryEditPerson = new ProcessorFactoryEditPerson(
                    List.of(actionProcessorEditPersonName, actionProcessorEditPersonSurname,
                            actionProcessorEditPersonPhoneNumber, actionProcessorEditPersonGender));

            IActionProcessor actionProcessorChouseRecord = new AddNewRecordProcessor(recordService, recordProcessorFactory);

            IActionProcessor actionProcessorCount = new CountPersonActionProcessor(recordService);

            IActionProcessor actionProcessorSearchNumber = new SearchActionProcessorNumber(recordService);
            IActionProcessor actionProcessorSearchBack = new SearchActionProcessorBack();
            IActionProcessor actionProcessorSearchAgain = new SearchActionProcessorAgain(recordService);
            ISearchProcessorFactory processorFactorySearch = new ProcessorFactorySearch(
                    List.of(actionProcessorSearchNumber, actionProcessorSearchBack, actionProcessorSearchAgain));

            IActionProcessor actionProcessorEdit = new EditRecordActionProcessor(recordService,
                    processorFactoryEditPerson, organizationEditProcessorFactory);
            IActionProcessor actionProcessorRemove = new RemovePersonActionProcessor(recordService);
            IActionProcessor actionProcessorExit = new ExitAppActionProcessor(recordService);

            IActionProcessor actionProcessorMenu = new MenuActionProcessor(recordService);

            IProcessorFactory processorFactory = new ProcessorFactory(List.of(actionProcessorCount,
                    actionProcessorEdit, actionProcessorRemove, actionProcessorExit, actionProcessorChouseRecord, actionProcessorMenu));

            IActionProcessor actionProcessorSearch = new SearchActionProcessor(recordService, processorFactory);

            IActionProcessor actionProcessorList = new ListPersonActionProcessor(recordService, processorFactory);
            processorFactory = new ProcessorFactory(List.of(actionProcessorCount, actionProcessorEdit,
                    actionProcessorRemove, actionProcessorExit, actionProcessorChouseRecord, actionProcessorList,
                    actionProcessorMenu, actionProcessorSearch));

            PhoneBook phoneBook = new PhoneBook(processorFactory);
            phoneBook.runPhoneBook();
        } catch (InputMismatchException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
