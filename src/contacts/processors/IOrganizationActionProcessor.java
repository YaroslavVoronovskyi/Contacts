package contacts.processors;

import contacts.model.Organization;

import java.io.IOException;

public interface IOrganizationActionProcessor {
    void doOrganizationAction(Organization organization) throws IOException;

    String getSupportedActionTitle();
}
