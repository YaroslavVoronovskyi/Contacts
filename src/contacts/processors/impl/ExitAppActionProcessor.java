package contacts.processors.impl;

import contacts.processors.IActionProcessor;

import java.io.IOException;

public class ExitAppActionProcessor implements IActionProcessor {

    @Override
    public boolean doAction() throws IOException {
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "exit";
    }
}