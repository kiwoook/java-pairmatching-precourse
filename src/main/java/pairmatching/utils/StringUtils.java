package pairmatching.utils;


import java.text.DecimalFormat;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import pairmatching.exception.CustomIllegalArgumentException;
import pairmatching.model.ErrorMessage;

public class StringUtils {

    private static final String OR = "|";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");


    private StringUtils() {
    }

    public static void validateNumber(String input) {
        validateIsNumeric(input);
        validateRange(input);
    }

    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private static void validateIsNumeric(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private static void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }


    public static String[] split(String regex, String input, Integer fieldCount) {
        if (regex == null || input == null || input.isEmpty() || input.endsWith(regex)) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }

        String[] split = input.split(regex);
        if (fieldCount != null && split.length != fieldCount) {
            throw new CustomIllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        return split;
    }

    public static String regexSeparators(List<String> separators) {
        StringJoiner regex = new StringJoiner(OR);

        for (String separator : separators) {
            regex.add(Pattern.quote(separator));
        }

        return regex.toString();
    }

    public static String regexSeparators(String separator, String... separators) {
        StringJoiner regex = new StringJoiner(OR);
        regex.add(separator);

        for (String sep : separators) {
            regex.add(Pattern.quote(sep));
        }

        return regex.toString();
    }

    public static String numberFormat(long number) {
        DecimalFormat format = new DecimalFormat("#,###");

        return format.format(number);
    }


}
