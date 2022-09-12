package contacts;

import contacts.service.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ConsoleReader {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String getStringFromConsole(String message) throws IOException {
        System.out.println(message);
        String value = bufferedReader.readLine();
        checkExpressionByNull(value);
        return value;
    }

    public static String getStringFromConsole(String message, Pattern pattern, String errorMessage) throws IOException {
        System.out.println(message);
        String value = null;
        boolean isValueValid = false;
        while (!isValueValid) {
            value = bufferedReader.readLine();
            checkExpressionByNull(value);
            isValueValid = Validator.validateFieldValue(value, pattern);
            if (!isValueValid) {
                System.out.println(errorMessage + Constants.LINE_SEPARATOR + message);
            }
        }
        return value;
    }

    public static int getIntFromConsole(String message, int maxIndex) throws IOException {
        System.out.println(message);
        int recordNumber = 0;
        boolean resultNotValid = false;
        do {
            if (resultNotValid) {
                System.out.println("Please enter correct record number");
            }
            try {
                recordNumber = Integer.parseInt(bufferedReader.readLine());
                resultNotValid = recordNumber <= 0 || recordNumber > maxIndex;
            } catch (NumberFormatException exception) {
                resultNotValid = true;
            }
        } while (resultNotValid);
        return recordNumber;
    }

    private static void checkExpressionByNull(String value) throws IOException {
        while (value == null) {
            System.out.println("expression can not be null or empty");
            value = bufferedReader.readLine();
        }
    }
}
