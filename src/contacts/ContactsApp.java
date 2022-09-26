package contacts;

import contacts.dao.IRecordDao;
import contacts.dao.impl.FileRecordDao;
import contacts.processors.IAddRecordProcessor;
import contacts.processors.IAddRecordProcessorFactory;
import contacts.processors.IEditRecordProcessor;
import contacts.processors.IPhoneBookActionProcessor;
import contacts.processors.IEditRecordProcessorFactory;
import contacts.processors.IPhoneBookProcessorFactory;
import contacts.processors.impl.add.AddNewOrganizationProcessor;
import contacts.processors.impl.add.AddNewPersonProcessor;
import contacts.processors.impl.add.AddRecordProcessorFactory;
import contacts.processors.impl.edit.EditAddressOrganizationProcessor;
import contacts.processors.impl.edit.EditBirthDatePersonProcessor;
import contacts.processors.impl.edit.EditGenderPersonProcessor;
import contacts.processors.impl.edit.EditNameRecordProcessor;
import contacts.processors.impl.edit.EditPhoneNumberRecordProcessor;
import contacts.processors.impl.edit.EditRecordProcessorFactory;
import contacts.processors.impl.edit.EditSurnamePersonProcessor;
import contacts.processors.impl.phonebook.AddNewRecordProcessor;
import contacts.processors.impl.phonebook.EditRecordProcessor;
import contacts.processors.impl.phonebook.CountRecordProcessor;
import contacts.processors.impl.phonebook.ExitApplicationProcessor;
import contacts.processors.impl.phonebook.PhoneBookProcessorFactory;
import contacts.processors.impl.phonebook.RemoveRecordProcessor;
import contacts.processors.impl.phonebook.SearchRecordProcessor;
import contacts.processors.impl.phonebook.ShowRecordsListProcessor;
import contacts.service.IRecordService;
import contacts.service.impl.RecordService;

import java.util.List;

public class ContactsApp {
    public static void main(String[] args) {

        IRecordDao fileRecordDao = new FileRecordDao();

        IRecordService recordService = new RecordService(fileRecordDao);

        IAddRecordProcessor addNewPersonProcessor = new AddNewPersonProcessor(recordService);
        IAddRecordProcessor addNewOrganizationProcessor = new AddNewOrganizationProcessor(recordService);

        IAddRecordProcessorFactory addRecordProcessorFactory = new AddRecordProcessorFactory(
                List.of(addNewPersonProcessor, addNewOrganizationProcessor));

        IEditRecordProcessor editAddressOrganizationProcessor = new EditAddressOrganizationProcessor(recordService);
        IEditRecordProcessor editNamePersonProcessor = new EditNameRecordProcessor(recordService);
        IEditRecordProcessor editSurnamePersonProcessor = new EditSurnamePersonProcessor(recordService);
        IEditRecordProcessor editPhoneNumberRecordProcessor = new EditPhoneNumberRecordProcessor(recordService);
        IEditRecordProcessor editGenderPersonProcessor = new EditGenderPersonProcessor(recordService);
        IEditRecordProcessor editBirthDatePersonProcessor = new EditBirthDatePersonProcessor(recordService);

        IEditRecordProcessorFactory editPersonProcessorFactory = new EditRecordProcessorFactory(
                List.of(editNamePersonProcessor, editSurnamePersonProcessor, editPhoneNumberRecordProcessor,
                        editGenderPersonProcessor, editAddressOrganizationProcessor, editBirthDatePersonProcessor));

        IPhoneBookActionProcessor addNewRecordProcessor = new AddNewRecordProcessor(addRecordProcessorFactory);
        IPhoneBookActionProcessor countRecordProcessor = new CountRecordProcessor(recordService);
        IPhoneBookActionProcessor removeRecordProcessor = new RemoveRecordProcessor(recordService);
        IPhoneBookActionProcessor exitApplicationProcessor = new ExitApplicationProcessor();
        IPhoneBookActionProcessor searchRecordProcessor = new SearchRecordProcessor(recordService);
        IPhoneBookActionProcessor showRecordsListProcessor = new ShowRecordsListProcessor(recordService);
        IPhoneBookActionProcessor editRecordProcessor = new EditRecordProcessor(recordService, editPersonProcessorFactory);

        IPhoneBookProcessorFactory phoneBookProcessorFactory = new PhoneBookProcessorFactory(List.of(countRecordProcessor, editRecordProcessor,
                removeRecordProcessor, exitApplicationProcessor, addNewRecordProcessor, showRecordsListProcessor,
                searchRecordProcessor));

        PhoneBook phoneBook = new PhoneBook(phoneBookProcessorFactory);
        phoneBook.runPhoneBook();
    }
}
