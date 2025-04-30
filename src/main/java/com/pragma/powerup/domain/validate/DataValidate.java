package com.pragma.powerup.domain.validate;

import com.pragma.powerup.domain.util.Constants;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Component
public class DataValidate {

    public static void validateDataNotNull (Object object, String... fieldsToValidate) {
        if (object == null){
            throw new IllegalArgumentException(Constants.NULL_OR_EMPTY);
        }

        List<String> fieldsList = Arrays.asList(fieldsToValidate);
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (!fieldsList.isEmpty() && fieldsList.contains(field.getName())){
                continue;
            }

            field.setAccessible(true);

            try {
                Object value = field.get(object);
                if (value == null || (value instanceof String && ((String) value).isBlank())) {
                    throw new IllegalArgumentException(Constants.FIELD_NULL+field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(Constants.MESSAGE_ERROR_GET_FIELD+field.getName(), e);
            }
        }
    }

    public void validateOnlyNumbers(String data, String fieldName) {
        if (!data.matches(Constants.ONLY_NUMBERS)){
            throw new IllegalArgumentException(Constants.INVALID_FIELD_ONLY_NUMBER+ fieldName);
        }
    }

    public void validatePhoneNumber (String phone) {
        if (phone.length() > Constants.MAX_LENGTH_PHONE || !phone.matches(Constants.VALIDATE_PHONE_NUMBER)){
            throw new IllegalArgumentException(Constants.INVALID_PHONE_NUMBER);
        }
    }

    public void validateNameRestaurant (String nameRestaurant) {
        if (!nameRestaurant.matches(Constants.NAME_OF_RESTAURANT)){
            throw new IllegalArgumentException(Constants.INVALID_NAME_RESTAURANT);
        }
    }
}
