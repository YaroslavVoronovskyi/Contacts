package contacts.service;

import contacts.ConsoleReader;
import contacts.Constants;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Constants.PHONE_NUMBER_CHECK_PATTERN;
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static String getValidPhoneNumberFromConsole() throws IOException {
        boolean isPhoneNumberValid = false;
        String number = null;
        while (!isPhoneNumberValid) {
            number = ConsoleReader.getStringFromConsole("Enter the phone number:");
            isPhoneNumberValid = Validator.validatePhoneNumber(number);
            if (!isPhoneNumberValid) {
                System.out.println(Constants.WRONG_NUMBER_FORMAT_ERROR);
                continue;
            }
        }
        return number;
    }
}
