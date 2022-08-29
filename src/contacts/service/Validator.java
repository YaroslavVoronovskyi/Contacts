package contacts.service;

import contacts.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Constants.PHONE_NUMBER_CHECK_PATTERN;
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
