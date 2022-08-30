package contacts.processors;

public interface ISearchRecordProcessorFactory {
    IActionProcessor getProcessorByTitle(String title);
}
