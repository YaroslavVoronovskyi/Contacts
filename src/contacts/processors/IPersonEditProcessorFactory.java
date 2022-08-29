package contacts.processors;

public interface IPersonEditProcessorFactory {
    IPersonActionProcessor getProcessorByTitle(String title);
}
