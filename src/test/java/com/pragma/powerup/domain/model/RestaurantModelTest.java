package com.pragma.powerup.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantModelTest {

    @Test
    void modelGetterAndSetterTest() {
        RestaurantModel restaurantModel = new RestaurantModel();

        restaurantModel.setId(1l);
        restaurantModel.setNombre("");
        restaurantModel.setIdPropietario("");
        restaurantModel.setCelular("");
        restaurantModel.setDireccion("");
        restaurantModel.setNit("");
        restaurantModel.setUrlLogo("");

        assertEquals(1l, restaurantModel.getId());
        assertEquals("", restaurantModel.getNombre());
        assertEquals("", restaurantModel.getIdPropietario());
        assertEquals("", restaurantModel.getCelular());
        assertEquals("", restaurantModel.getDireccion());
        assertEquals("", restaurantModel.getNit());
        assertEquals("", restaurantModel.getUrlLogo());
    }

}