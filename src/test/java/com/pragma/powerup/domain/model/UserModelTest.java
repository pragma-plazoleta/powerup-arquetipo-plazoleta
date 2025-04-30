package com.pragma.powerup.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {

    @Test
    void modelGetterAndSetterTest() {
        UserModel userModel = new UserModel();

        userModel.setId(1l);
        userModel.setNombre("");
        userModel.setApellido("");
        userModel.setCelular("");
        userModel.setCorreo("");
        userModel.setNumeroDocumento("");
        userModel.setNombreRol("");

        assertEquals(1l, userModel.getId());
        assertEquals("", userModel.getNombre());
        assertEquals("", userModel.getApellido());
        assertEquals("", userModel.getCelular());
        assertEquals("", userModel.getCorreo());
        assertEquals("", userModel.getNumeroDocumento());
        assertEquals("", userModel.getNombreRol());
    }

}