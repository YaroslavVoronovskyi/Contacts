package contacts;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Constants {
    public static final Pattern PHONE_NUMBER_CHECK_PATTERN =
            Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
    public static final Pattern BIRTH_DATE_CHECK_PATTERN =
            Pattern.compile("^(((0[1-9]|[12]\\d|3[01])/(0[13578]|1[02])/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)" +
                    "/(0[13456789]|1[012])/((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])/02/((19|[2-9]\\d)\\d{2}))|(29/02/" +
                    "((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$");
    public static final Pattern NAME_CHECK_PATTERN = Pattern.compile("^([a-zA-Z]{2,}?)");
    public static final Pattern SURNAME_CHECK_PATTERN = Pattern.compile("^([a-zA-Z]{2,}?)");
    public static final Pattern GENDER_CHECK_PATTERN = Pattern.compile("[MF]$");
    public static final Pattern ADDRESS_CHECK_PATTERN = Pattern.compile("^([a-zA-Z]{2,}\\s[a-zA-Z]+'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]+)?)");
    public static final Pattern SEARCH_QUERY_CHECK_PATTERN = Pattern.compile("^([a-zA-Z]{2,}?)");
    public static final String WRONG_NUMBER_FORMAT_ERROR = "Wrong number format!";
    public static final String WRONG_BIRTH_DATE_FORMAT_ERROR = "Wrong birth date format!";
    public static final String WRONG_NAME_FORMAT_ERROR = "Wrong name format!";
    public static final String WRONG_SURNAME_FORMAT_ERROR = "Wrong surname format!";
    public static final String WRONG_ADDRESS_FORMAT_ERROR = "Wrong address format!";
    public static final String WRONG_SEARCH_QUERY_FORMAT_ERROR = "Wrong query format!";
    public static final String WRONG_TITLE_ERROR = "Wrong title!";
    public static final String WRONG_GENDER_ERROR = "Wrong gender!";
    public static final String DELIMETER = " ";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String DOT_SEPARATOR = ". ";
    public static final String FILE_NAME = "database.txt";
    public static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
}
