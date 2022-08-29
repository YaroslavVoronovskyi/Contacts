package contacts.processors;

import contacts.model.Organization;

import java.io.IOException;

public interface IOrganizationActionProcessor {
    void doActionOrganization(Organization organization) throws IOException;

    String getSupportedActionTitle();
}
