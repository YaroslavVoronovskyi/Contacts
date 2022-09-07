package contacts.processors;

import java.io.IOException;

public interface ISearchRecordProcessorFactory {
    IActionProcessor getProcessorByTitle(String title) throws IOException;
}
