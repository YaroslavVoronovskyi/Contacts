package contacts.processors;

public interface IEditRecordProcessorFactory {
    IEditRecordActionProcessor getProcessorByTitle(String title);
}
