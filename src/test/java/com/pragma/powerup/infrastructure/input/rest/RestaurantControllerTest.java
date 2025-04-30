package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.RestaurantRequestDto;
import com.pragma.powerup.application.handler.IRestaurantHandler;
import com.pragma.powerup.domain.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestaurantControllerTest {

    private RestaurantController restaurantController;
    private IRestaurantHandler restaurantHandler;

    @BeforeEach
    void setup() {
        restaurantHandler = mock(IRestaurantHandler.class);
        restaurantController = new RestaurantController(restaurantHandler);
    }

    @Test
    void saveRestaurant() {
        RestaurantRequestDto restaurantRequestDto = new RestaurantRequestDto();
        Map<String, String> headers =  new HashMap<>();

        ResponseEntity<String> expectResponse = new ResponseEntity<>(Constants.MESSAGE_SUCCESS_CREATE_RESTAURANT, HttpStatus.OK);
        Mockito.when(restaurantHandler.saveRestaurant(restaurantRequestDto, headers)).thenReturn(expectResponse);

        assertEquals(restaurantController.saveRestaurant(restaurantRequestDto, headers), expectResponse);
        verify(restaurantHandler, times(1)).saveRestaurant(restaurantRequestDto, headers);
    }

}