package com.pragma.powerup.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserResponseDtoTest {

    @Test
    void dtoGetterAndSetterTest() {
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(1L);
        userResponseDto.setNombre("");
        userResponseDto.setApellido("");
        userResponseDto.setCorreo("");
        userResponseDto.setCelular("");
        userResponseDto.setNumeroDocumento("");
        userResponseDto.setNombreRol("");

        assertEquals(1L,userResponseDto.getId());
        assertEquals("",userResponseDto.getNombre());
        assertEquals("",userResponseDto.getApellido());
        assertEquals("",userResponseDto.getCorreo());
        assertEquals("",userResponseDto.getCelular());
        assertEquals("",userResponseDto.getNumeroDocumento());
        assertEquals("",userResponseDto.getNombreRol());

    }

}