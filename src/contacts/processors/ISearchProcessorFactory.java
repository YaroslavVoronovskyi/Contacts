package contacts.processors;

public interface ISearchProcessorFactory {
    IActionProcessor getProcessorByTitle(String title);
}
