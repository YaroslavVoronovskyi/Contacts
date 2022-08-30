package contacts.processors.impl;

import contacts.model.Record;
import contacts.processors.IPersonActionProcessor;

import java.io.IOException;

public class ExitPersonActionProcessor implements IPersonActionProcessor {

    @Override
    public void doAction(Record record) throws IOException {

    }

    @Override
    public String getSupportedActionTitle() {
        return "exit";
    }
}
