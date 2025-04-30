package com.pragma.powerup.domain.validate;

import com.pragma.powerup.domain.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataValidateTest {

    private DataValidate dataValidate;

    @BeforeEach
    void setUp() {
        dataValidate = new DataValidate();
    }

    static class DummyObject {
        private String name;
        private String email;
        private String optionalField;

        public DummyObject(String name, String email, String optionalField) {
            this.name = name;
            this.email = email;
            this.optionalField = optionalField;
        }
    }

    @Test
    void validateDataNotNull_shouldPassWhenAllFieldsAreValid() {
        DummyObject obj = new DummyObject("John", "john@example.com", "optional");
        assertDoesNotThrow(() -> DataValidate.validateDataNotNull(obj));
    }

    @Test
    void validateDataNotNull_shouldThrowWhenFieldIsNull() {
        DummyObject obj = new DummyObject(null, "john@example.com", "optional");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> DataValidate.validateDataNotNull(obj));
        assertTrue(exception.getMessage().contains(Constants.FIELD_NULL + "name"));
    }

    @Test
    void validateDataNotNull_shouldSkipOptionalField() {
        DummyObject obj = new DummyObject("John", "john@example.com", null);
        assertDoesNotThrow(() -> DataValidate.validateDataNotNull(obj, "optionalField"));
    }

    @Test
    void validateOnlyNumbers_shouldPassForValidNumber() {
        assertDoesNotThrow(() -> dataValidate.validateOnlyNumbers("123456", "field"));
    }

    @Test
    void validateOnlyNumbers_shouldThrowForInvalidNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> dataValidate.validateOnlyNumbers("abc123", "field"));
        assertEquals(Constants.INVALID_FIELD_ONLY_NUMBER + "field", exception.getMessage());
    }

    @Test
    void validatePhoneNumber_shouldPassForValidPhone() {
        assertDoesNotThrow(() -> dataValidate.validatePhoneNumber("+573001234567"));
    }

    @Test
    void validatePhoneNumber_shouldThrowForInvalidPhone() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> dataValidate.validatePhoneNumber("123abc"));
        assertEquals(Constants.INVALID_PHONE_NUMBER, exception.getMessage());
    }

    @Test
    void validateNameRestaurant_shouldPassForValidName() {
        assertDoesNotThrow(() -> dataValidate.validateNameRestaurant("Mi Restaurante"));
    }

    @Test
    void validateNameRestaurant_shouldThrowForInvalidName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> dataValidate.validateNameRestaurant("Restaurante@123"));
        assertEquals(Constants.INVALID_NAME_RESTAURANT, exception.getMessage());
    }
}
