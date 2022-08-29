package contacts;

import contacts.service.PersonServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static PersonServiceImpl personService = new PersonServiceImpl();

    public static String getPersonData() throws IOException {
        return bufferedReader.readLine();
    }

    public static int getRecordNumber() throws IOException {
        int listSize = personService.getRecordsCount();
        int recordNumber = 0;
        boolean resultNotValid = false;
        do {
            if (resultNotValid) {
                System.out.println("Please enter correct record number");
            }
            try {
                recordNumber = Integer.parseInt(ConsoleReader.getPersonData());
                resultNotValid = recordNumber > listSize;
            } catch (NumberFormatException | IndexOutOfBoundsException exception) {
                resultNotValid = true;
            }
        } while (resultNotValid);
        return recordNumber;
    }

    public static String getStringFromConsole(String message) throws IOException {
        System.out.println(message);
        return bufferedReader.readLine();
    }
}
