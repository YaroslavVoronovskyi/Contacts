package contacts;

import contacts.dao.IRecordDao;
import contacts.dao.impl.FileRecordDao;
import contacts.processors.*;
import contacts.processors.impl.*;
import contacts.service.IRecordService;
import contacts.service.impl.RecordService;

import java.io.IOException;
import java.util.List;

public class ApplicationContacts {
    public static void main(String[] args) {
        try {
            IRecordDao fileRecordDao = new FileRecordDao();

            IRecordService recordService = new RecordService(fileRecordDao);

            IRecordActionProcessor addNewPersonProcessor = new AddNewPersonProcessor(recordService);
            IRecordActionProcessor addNewOrganizationProcessor = new AddNewOrganizationProcessor(recordService);

            IRecordProcessorFactory recordProcessorFactory = new RecordProcessorFactory(
                    List.of(addNewPersonProcessor, addNewOrganizationProcessor));

            IEditRecordActionProcessor editAddressOrganizationProcessor = new EditAddressOrganizationProcessor(recordService);
            IEditRecordActionProcessor editNamePersonProcessor = new EditNameRecordProcessor(recordService);
            IEditRecordActionProcessor editSurnamePersonProcessor = new EditSurnamePersonProcessor(recordService);
            IEditRecordActionProcessor editPhoneNumberRecordProcessor = new EditPhoneNumberRecordProcessor(recordService);
            IEditRecordActionProcessor editGenderPersonProcessor = new EditGenderPersonProcessor(recordService);
            IEditRecordActionProcessor editBirthDatePersonProcessor = new EditBirthDatePersonProcessor(recordService);

            IEditRecordProcessorFactory editPersonProcessorFactory = new EditPersonProcessorFactory(
                    List.of(editNamePersonProcessor, editSurnamePersonProcessor, editPhoneNumberRecordProcessor,
                            editGenderPersonProcessor, editAddressOrganizationProcessor, editBirthDatePersonProcessor));

            IActionProcessor chooseTypeRecordProcessor = new ChooseTypeRecordProcessor(recordProcessorFactory);
            IActionProcessor countRecordProcessor = new CountRecordProcessor(recordService);
            IActionProcessor removeRecordProcessor = new RemoveRecordProcessor(recordService);
            IActionProcessor exitApplicationProcessor = new ExitAppActionProcessor();
            IActionProcessor searchRecordProcessor = new SearchRecordProcessor(recordService);
            IActionProcessor showRecordsListProcessor = new ShowRecordsListProcessor(recordService);
            IActionProcessor editRecordProcessor = new EditRecordProcessor(recordService, editPersonProcessorFactory);

            IProcessorFactory phoneBookProcessorFactory = new ProcessorFactory(List.of(countRecordProcessor, editRecordProcessor,
                    removeRecordProcessor, exitApplicationProcessor, chooseTypeRecordProcessor, showRecordsListProcessor,
                    searchRecordProcessor));

            PhoneBook phoneBook = new PhoneBook(phoneBookProcessorFactory);
            phoneBook.runPhoneBook();
        } catch (NumberFormatException | IOException | ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
