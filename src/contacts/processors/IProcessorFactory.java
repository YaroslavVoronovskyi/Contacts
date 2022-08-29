package contacts.processors;

public interface IProcessorFactory {
    IActionProcessor getProcessorByTitle(String title);
}
