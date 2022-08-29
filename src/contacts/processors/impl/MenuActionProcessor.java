package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.processors.IActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;

public class MenuActionProcessor implements IActionProcessor {

    private final IRecordService recordService;

    public MenuActionProcessor(IRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public boolean doAction() throws IOException {
        String actionTitle = ConsoleReader.getPersonData();
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "menu";
    }
}
