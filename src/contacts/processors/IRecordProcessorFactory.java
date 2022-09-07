package contacts.processors;

import java.io.IOException;

public interface IRecordProcessorFactory {
    IRecordActionProcessor getProcessorByTitle(String title) throws IOException;
}
