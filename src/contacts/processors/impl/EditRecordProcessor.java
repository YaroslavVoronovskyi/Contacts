package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.Constants;
import contacts.model.Record;
import contacts.processors.*;
import contacts.service.IRecordService;

import java.io.IOException;
import java.util.List;

public class EditRecordProcessor implements IActionProcessor {
    private final IRecordService recordService;
    private final IEditRecordProcessorFactory editRecordProcessorFactory;

    public EditRecordProcessor(IRecordService recordService, IEditRecordProcessorFactory editRecordProcessorFactory) {
        this.recordService = recordService;
        this.editRecordProcessorFactory = editRecordProcessorFactory;
    }

    @Override
    public boolean doAction() throws IOException, ClassNotFoundException {
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
        String editRecordAction = ConsoleReader.getStringFromConsole(currentRecord.getEditRecordFieldMessage());

        IEditRecordActionProcessor editRecordProcessor = editRecordProcessorFactory.getProcessorByTitle(editRecordAction);
        editRecordProcessor.doAction(currentRecord);
        System.out.println();
        return true;
    }

    @Override
    public String getSupportedActionTitle() {
        return "edit";
    }
}
