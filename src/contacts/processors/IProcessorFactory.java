package contacts.processors;

import java.io.IOException;

public interface IProcessorFactory {
    IActionProcessor getProcessorByTitle(String title) throws IOException;
}
