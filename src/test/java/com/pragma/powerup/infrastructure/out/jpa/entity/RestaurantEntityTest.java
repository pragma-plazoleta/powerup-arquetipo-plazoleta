package com.pragma.powerup.infrastructure.out.jpa.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantEntityTest {

    @Test
    void entityGetterAndSetterTest() {
        RestaurantEntity restaurantEntity = new RestaurantEntity();

        restaurantEntity.setId(2L);
        restaurantEntity.setNombre("");
        restaurantEntity.setCelular("");
        restaurantEntity.setDireccion("");
        restaurantEntity.setNit("");
        restaurantEntity.setIdPropietario(1l);
        restaurantEntity.setUrlLogo("");

        assertEquals(2L, restaurantEntity.getId());
        assertEquals("", restaurantEntity.getNombre());
        assertEquals("", restaurantEntity.getCelular());
        assertEquals("", restaurantEntity.getDireccion());
        assertEquals("", restaurantEntity.getNit());
        assertEquals("", restaurantEntity.getUrlLogo());
        assertEquals(1L, restaurantEntity.getIdPropietario());
    }

    @Test
    void entityConstructorTest() {
        RestaurantEntity restaurantEntity = new RestaurantEntity(2L, "", "", 1L, "","","");

        assertNotNull(restaurantEntity);
    }

}