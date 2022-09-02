package contacts.processors;

import java.io.IOException;

public interface IActionProcessor {
    boolean doAction() throws IOException, ClassNotFoundException;

    String getSupportedActionTitle();
}
