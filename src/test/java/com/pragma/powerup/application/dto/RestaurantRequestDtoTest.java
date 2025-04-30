package com.pragma.powerup.application.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantRequestDtoTest {

    @Test
    void dtoGettetAndSetterTest() {
        RestaurantRequestDto restaurantRequestDto = new RestaurantRequestDto();

        restaurantRequestDto.setNombre("");
        restaurantRequestDto.setCelular("");
        restaurantRequestDto.setDireccion("");
        restaurantRequestDto.setNit("");
        restaurantRequestDto.setUrlLogo("");
        restaurantRequestDto.setIdPropietario(1l);

        assertEquals("", restaurantRequestDto.getNombre());
        assertEquals("", restaurantRequestDto.getCelular());
        assertEquals("", restaurantRequestDto.getDireccion());
        assertEquals("", restaurantRequestDto.getNit());
        assertEquals("", restaurantRequestDto.getUrlLogo());
        assertEquals(1l, restaurantRequestDto.getIdPropietario());

    }

}