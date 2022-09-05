package contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String getStringFromConsole() throws IOException {
        String expression = bufferedReader.readLine();
        checkExpressionByNull(expression);
        return expression;
    }

    public static String getStringFromConsole(String message) throws IOException {
        System.out.println(message);
        String expression = bufferedReader.readLine();
        checkExpressionByNull(expression);
        return expression;
    }

    public static int getIntFromConsole(String message) throws IOException {
        System.out.println(message);
        int recordNumber = 0;
        boolean resultNotValid = false;
        do {
            if (resultNotValid) {
                System.out.println("Please enter correct record number");
            }
            try {
                recordNumber = Integer.parseInt(bufferedReader.readLine());
                resultNotValid = recordNumber < 0;
            } catch (NumberFormatException | IndexOutOfBoundsException exception) {
                resultNotValid = true;
            }
        } while (resultNotValid);
        System.out.println(message);
        return recordNumber;
    }

    private static void checkExpressionByNull(String expression) throws IOException {
        while (expression == null || expression.trim().isEmpty()) {
            System.out.println("expression can not be null or empty");
            expression = bufferedReader.readLine();
        }
    }
}
