package contacts.processors;

public interface IEditOrganizationProcessorFactory {
    IOrganizationActionProcessor getProcessorByTitle(String title);
}
