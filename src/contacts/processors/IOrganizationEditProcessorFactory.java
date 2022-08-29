package contacts.processors;

public interface IOrganizationEditProcessorFactory {
    IOrganizationActionProcessor getProcessorByTitle(String title);
}
