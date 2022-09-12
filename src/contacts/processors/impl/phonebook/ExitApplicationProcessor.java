package contacts.processors.impl.phonebook;

import contacts.processors.IPhoneBookActionProcessor;

public class ExitApplicationProcessor implements IPhoneBookActionProcessor {

    @Override
    public boolean doAction() {
        return false;
    }

    @Override
    public String getSupportedActionTitle() {
        return "exit";
    }
}