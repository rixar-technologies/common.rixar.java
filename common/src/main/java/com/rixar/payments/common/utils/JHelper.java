package com.rixar.payments.common.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rixar.payments.common.codes.RespCode;
import com.rixar.payments.common.exceptions.RixarRuntimeException;
import org.jboss.logging.Logger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class JHelper {

    private static final Logger log = Logger.getLogger(JHelper.class);

    public static String toJson(Object object) {

        if (object == null) {
            return null;
        }

        if (object instanceof File) {
            log.warn("can not stringify file");
            return "can not stringify file";
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            return objectMapper.writeValueAsString(object);
        } catch (Exception exception) {
            log.errorf(exception,"Could not convert object %s to JSON String  %s %s", object.getClass().getSimpleName(), exception.getMessage(), object);
            return "";
        }
    }


    public static <T> T fromJson(String jsonString, Class<T> classOfT) {

        if (GoodStringUtil.isEmpty(jsonString)) {
            log.info("invalid json string `{}`. parse failed"+jsonString);
            return null;
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            return objectMapper.readValue(jsonString, classOfT);
        } catch (Exception exception) {
            log.error(exception);
            throw new RixarRuntimeException("Failed to convert json string to java object", RespCode.UNKNOWN_ERROR);
        }
    }

    public static <T> T fromJson(String jsonString, TypeReference<T> typeReference) throws RixarRuntimeException {

        if (GoodStringUtil.isEmpty(jsonString)) {
            log.infof("invalid json string  `%s`", jsonString);
            return null;
        }

        T data;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
            data = objectMapper.readValue(jsonString, typeReference);
        } catch (Exception exception) {
            log.errorf("Could parse JSON String %s `%s`", exception.getMessage(), jsonString);
            throw new RixarRuntimeException("Failed to convert json string to java object", RespCode.UNKNOWN_ERROR);
        }
        return data;
    }

    /**
     * extracts all field names from an object
     *
     * @return listOfFieldNames
     */
    public static List<String> getFieldNames(Object object) {

        String json = toJson(object);
        LinkedHashMap<String, String> linkedHashMap = fromJson(json, new TypeReference<>() {
        });
        List<String> fieldNamesArray = new ArrayList<>();

        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            fieldNamesArray.add(entry.getKey());
        }
        return fieldNamesArray;
    }


    public static HashMap<String, String> toMap(Object object) {
        String json = toJson(object);
        return fromJson(json, new TypeReference<>() {
        });
    }


    /**
     * Returns specified n last characters
     */
    public static String getAccountSuffix(String account, int charCount) {
        return account.substring((account.length()) - charCount);
    }

    public static String formatCurrentDate(String format) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }


    public static boolean isHttp(String url) {
        return url.startsWith("http") || url.startsWith("https");
    }


    /**
     * String helpers
     **/
    public static boolean isEmpty(String value) {
        if (value == null) {
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

    public static String render(String baseString, Object... arguments) {
        for (Object arg : arguments) {
            baseString = baseString.replaceFirst("\\{}", arg == null ? "null" : String.valueOf(arg));
        }
        return baseString;
    }

    public static String getMessage(Exception exception, String defaultMessage) {
        try {
            if (exception instanceof RixarRuntimeException) {
                return defaultMessage + " " + exception.getMessage();
            }

            return exception.getClass().getSimpleName() + " " + defaultMessage;
        } catch (Exception e) {
            return defaultMessage;
        }
    }

    public static String phraseException(Exception exception, String defaultMessage) {
        try {
            if (exception instanceof RixarRuntimeException) {
                return defaultMessage + " " + exception.getMessage();
            }
            return exception.getClass().getSimpleName() + " " + defaultMessage;
        } catch (Exception e) {
            return defaultMessage;
        }
    }

}
