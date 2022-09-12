package contacts.processors;

public interface IPhoneBookProcessorFactory {

    IPhoneBookActionProcessor getProcessorByAction(String actionTitle);
}
