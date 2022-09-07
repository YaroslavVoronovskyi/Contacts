package contacts.processors;

import java.io.IOException;

public interface IRecordActionProcessor {
    void doAction() throws IOException;

    String getSupportedActionTitle();
}
