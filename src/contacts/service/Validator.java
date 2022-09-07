package contacts.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

//    public static boolean validateValueByPattern(String value, Pattern pattern) {
////        boolean isValueValid = false;
////        while (!isValueValid) {
//////            value = ConsoleReader.getStringFromConsole(message);
////            isValueValid = validateFieldValue(value, pattern);
////            if (!isValueValid) {
////                System.out.println(errorMessage);
////            }
////        }
//
//
//        return validateFieldValue(value, pattern);
//    }

    public static boolean validateFieldValue(String value, Pattern pattern) {
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
