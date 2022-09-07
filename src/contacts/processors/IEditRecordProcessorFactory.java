package contacts.processors;

import java.io.IOException;

public interface IEditRecordProcessorFactory {
    IEditRecordActionProcessor getProcessorByTitle(String title) throws IOException;
}
