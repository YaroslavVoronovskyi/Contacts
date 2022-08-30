package contacts;

import java.util.regex.Pattern;

public class Constants {
    public static final Pattern PHONE_NUMBER_CHECK_PATTERN =
            Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*");
    public static final String WRONG_NUMBER_FORMAT_ERROR = "Wrong number format!";
    public static final String DELIMETER = " ";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String COMA_SEPARATOR = ", ";

}
