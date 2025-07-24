package com.rixar.payments.common.utils;

import org.jboss.logging.Logger;

import java.math.BigInteger;
import java.util.Base64;

 public class GoodStringUtil {

    private static final Logger log = Logger.getLogger(GoodStringUtil.class);

    public static String getExtensionFromName(String fileName) {

        if (JHelper.isEmpty(fileName)) {
            return "";
        }

        String[] phrases = fileName.split("\\.");

        if (phrases.length == 0) {
            return "";
        }
        return phrases[phrases.length - 1];
    }

    public static String orDefault(String value, String defaultValue) {
        if (isEmpty(value)) {
            return defaultValue;
        }
        return value;
    }

    public static String orEmpty(String value) {
        if (isEmpty(value)) {
            return "";
        }
        return value;
    }

    public static String withPrefixIfNotEmpty(String value, String prefix) {
        if (isEmpty(value)) {
            return "";
        }
        return prefix + value;
    }

    public static String getPrefixMasked(String value, int charsToShow) {
        return getPrefix(value, charsToShow) + "***";
    }

    public static String getPrefix(String value, int charsToShow) {
        if (isEmpty(value)) {
            return "";
        }

        if (value.trim().length() <= charsToShow) {
            return "";
        }
        return value.substring(0, charsToShow - 1);
    }

    public static String getSuffix(String value, int charsToShow) {
        if (isEmpty(value)) {
            return "";
        }

        if (value.trim().length() <= charsToShow) {
            return "";
        }
        return "***" + value.substring((value.length() - 1) - charsToShow);
    }

    public static boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }
        if (value.equalsIgnoreCase("null")) {
            return true;
        }
        return value.trim().isEmpty();
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static boolean areEmpty(String value1, String value2) {
        if (value1 == null || value2 == null) {
            return true;
        }
        return value1.trim().isEmpty() || value2.trim().isEmpty();
    }

    public static boolean bothEmpty(String value1, String value2) {
        return GoodStringUtil.isEmpty(value1) && GoodStringUtil.isEmpty(value2);
    }

    public static boolean areNotEmpty(String value1, String value2) {
        return !areEmpty(value1, value2);
    }

    public static boolean areEmpty(String value1, String value2, String value3) {
        if (value1 == null || value2 == null || value3 == null) {
            return true;
        }
        return value1.trim().isEmpty() || value2.trim().isEmpty() || value3.trim().isEmpty();
    }

    public static boolean areNotEmpty(String value1, String value2, String value3) {
        return !areEmpty(value1, value2, value3);
    }

    public static boolean areEqual(String value1, String value2) {
        if (GoodStringUtil.isEmpty(value1) && GoodStringUtil.isNotEmpty(value2)) {
            return false;
        }

        if (GoodStringUtil.isEmpty(value2) && GoodStringUtil.isNotEmpty(value2)) {
            return false;
        }

        if (GoodStringUtil.isEmpty(value2) && GoodStringUtil.isEmpty(value2)) {
            return true;
        }

        return value1.equalsIgnoreCase(value2);
    }

    public static String render(String baseString, Object... arguments) {
        for (Object arg : arguments) {
            baseString = baseString.replaceFirst("\\{}", arg == null ? "null" : String.valueOf(arg));
        }
        return baseString;
    }

    public static String toBase36(long longVal) {
        try {
            return Long.toString(longVal, 36).toUpperCase();
        } catch (NumberFormatException | NullPointerException ex) {
            log.info(ex.getMessage());
        }
        return "--";
    }

    public static String toBase64(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }


    /**
     * Removes all characters that are not allowed in Base64 encoding.
     * <p>
     * Base64 uses A-Z, a-z, 0-9, +, and / characters.
     *
     * @param input The input text to be filtered
     * @return Text containing only Base64-allowed characters
     */
    public static String removeNonBase64Chars(String input) {
        // Use regex to keep only Base64 characters
        return input.replaceAll("[^A-Za-z0-9+/]", "");
    }

    public static String fromBase64(String value) {
        try {
            byte[] decode = Base64.getDecoder().decode(value);
            return new String(decode);
        } catch (Exception e) {
            log.error("failed to decode base64String {}", value, e);
            throw e;
        }
    }

    public static Long toLong(String numberString) {
        try {
            return Long.parseLong(numberString);
        } catch (Exception e) {
            return null;
        }
    }

    public static String fromBase36(String b36) {
        try {
            BigInteger base = new BigInteger(b36, 36);
            return base.toString(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String limit(String value, int charCount) {
        if (isEmpty(value)) {
            return value;
        }

        if (value.length() <= charCount) {
            return value;
        }

        return value.substring(0, charCount - 1);
    }

    public static boolean isLessThan(String value, int charCount) {
        if (isEmpty(value)){
            return true;
        }
        return value.length() < charCount;
    }

    public static String uniqueOrConcat(String string1, String string2) {
        if (GoodStringUtil.areEmpty(string1, string2)) {
            return "";
        }
        if (GoodStringUtil.isEmpty(string1)) {
            return string2;
        }
        if (GoodStringUtil.isEmpty(string2)) {
            return string1;
        }

        if (string1.trim().equalsIgnoreCase(string2.trim())) {
            return string1;
        }
        return string1 + " ~ " + string2;
    }

}
