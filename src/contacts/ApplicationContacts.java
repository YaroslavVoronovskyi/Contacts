package contacts;


import contacts.dao.IRecordDao;
import contacts.dao.impl.FileRecordDao;
import contacts.dao.impl.InMemoryDao;
import contacts.processors.*;
import contacts.processors.impl.*;
import contacts.service.impl.IRecordService;
import contacts.service.RecordService;

import java.io.IOException;
import java.util.List;

public class ApplicationContacts {
    public static void main(String[] args) throws IOException {
        try {
//            IRecordDao inMemoryDao = new InMemoryDao();

            IRecordDao inMemoryDao = new FileRecordDao();

           // IRecordService recordService = new RecordService(inMemoryDao);

            IRecordService recordService = new RecordService(inMemoryDao);

            IRecordActionProcessor addNewPersonProcessor = new AddNewPersonProcessor(recordService);
            IRecordActionProcessor addNewOrganizationProcessor = new AddNewOrganizationProcessor(recordService);

            IRecordProcessorFactory recordProcessorFactory = new RecordProcessorFactory(
                    List.of(addNewPersonProcessor, addNewOrganizationProcessor));

            IEditRecordActionProcessor editAddressOrganizationProcessor = new EditAddressOrganizationProcessor(recordService);

            IEditRecordActionProcessor editNamePersonProcessor = new EditNameRecordProcessor(recordService);
            IEditRecordActionProcessor editSurnamePersonProcessor = new EditSurnamePersonProcessor(recordService);
            IEditRecordActionProcessor editPhoneNumberRecordProcessor = new EditPhoneNumberRecordProcessor(recordService);
            IEditRecordActionProcessor editGenderPersonProcessor = new EditGenderPersonProcessor(recordService);

            IEditRecordProcessorFactory editPersonProcessorFactory = new EditPersonProcessorFactory(
                    List.of(editNamePersonProcessor, editSurnamePersonProcessor,
                            editPhoneNumberRecordProcessor, editGenderPersonProcessor, editAddressOrganizationProcessor));

            IActionProcessor chooseTypeRecordProcessor = new ChooseTypeRecordProcessor(recordService, recordProcessorFactory);

            IActionProcessor countRecordProcessor = new CountRecordProcessor(recordService);

            IActionProcessor searchPhoneNumberRecordProcessor = new SearchPhoneNumberRecordProcessor(recordService);
            IActionProcessor searchBackRecordProcessor = new SearchBackRecordProcessor();
            IActionProcessor searchAgainRecordProcessor = new SearchAgainRecordProcessor(recordService);
            ISearchRecordProcessorFactory searchRecordProcessorFactory = new SearchRecordProcessorFactory(
                    List.of(searchPhoneNumberRecordProcessor, searchBackRecordProcessor, searchAgainRecordProcessor));

            IActionProcessor editRecordProcessor = new EditRecordProcessor(recordService,
                    editPersonProcessorFactory);
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
        } catch (NumberFormatException | IndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
