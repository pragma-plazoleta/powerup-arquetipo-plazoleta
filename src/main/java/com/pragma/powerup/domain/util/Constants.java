package com.pragma.powerup.domain.util;

public class Constants {

    public static final String NULL_OR_EMPTY = "Informacion nula o vacia";
    public static final String MESSAGE_ERROR_GET_FIELD = "Error al acceder al campo: ";
    public static final String FIELD_NULL = "Informacion nula del campo ";
    public static final String INVALID_FIELD_ONLY_NUMBER = "Solo se permite caracteres numericos en este campo";
    public static final String INVALID_PHONE_NUMBER = "El número de teléfono no puede tener más de 13 caracteres";
    public static final String INVALID_NAME_RESTAURANT = "El nombre invalido del restaurante";
    public static final String ROL_ADMINISTRADOR = "ADMINISTRADOR";
    public static final String ROL_PROPIETARIO = "PROPIETARIO";
    public static final String MESSAGE_ERROR_INVALID_ROL = "El rol del usuario no es propietario";
    public static final String MESSAGE_SUCCESS_CREATE_RESTAURANT = "Restaurante creado exitosamente";

    public static final int MAX_LENGTH_PHONE = 13;

    public static final String ONLY_NUMBERS = "^\\d+$";
    public static final String VALIDATE_PHONE_NUMBER = "^\\+?\\d{1,12}$";
    public static final String NAME_OF_RESTAURANT = "^(?!\\d+$)[a-zA-Z0-9\\s]+$";

}
