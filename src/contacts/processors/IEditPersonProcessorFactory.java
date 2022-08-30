package contacts.processors;

public interface IEditPersonProcessorFactory {
    IPersonActionProcessor getProcessorByTitle(String title);
}
