package contacts.processors.impl;

import contacts.ConsoleReader;
import contacts.processors.IActionProcessor;
import contacts.service.IRecordService;

import java.io.IOException;

public class MenuApplicationProcessor implements IActionProcessor {

    @Override
    public boolean doAction() throws IOException {
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "menu";
    }
}
