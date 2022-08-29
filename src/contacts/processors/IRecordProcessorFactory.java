package contacts.processors;

public interface IRecordProcessorFactory {
    IRecordActionProcessor getProcessorByTitle(String title);
}
