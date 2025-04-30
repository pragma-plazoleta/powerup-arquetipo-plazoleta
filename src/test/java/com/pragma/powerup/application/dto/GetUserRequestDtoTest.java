package com.pragma.powerup.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetUserRequestDtoTest {

    @Test
    void dtoGetterAndSetterTest() {
        GetUserRequestDto getUserRequestDto = new GetUserRequestDto();

        getUserRequestDto.setId("");

        assertEquals("", getUserRequestDto.getId());
    }

}