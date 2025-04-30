package com.pragma.powerup.application.handler.imlp;

import com.pragma.powerup.application.dto.RestaurantRequestDto;
import com.pragma.powerup.application.mapper.request.IRestaurantRequestMapper;
import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.model.RestaurantModel;
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

class RestaurantHandlerTest {

    private RestaurantHandler restaurantHandler;
    private IRestaurantServicePort restaurantServicePort;
    private IRestaurantRequestMapper restaurantRequestMapper;

    @BeforeEach
    void setup() {
        restaurantServicePort = mock(IRestaurantServicePort.class);
        restaurantRequestMapper = mock(IRestaurantRequestMapper.class);
        restaurantHandler = new RestaurantHandler(restaurantRequestMapper, restaurantServicePort);
    }

    @Test
    void saveRestaurant() {
        RestaurantRequestDto restaurantRequestDto = new RestaurantRequestDto();
        Map<String, String> headers =  new HashMap<>();
        RestaurantModel restaurantModel = new RestaurantModel();

        Mockito.when(restaurantRequestMapper.toModel(restaurantRequestDto)).thenReturn(restaurantModel);
        ResponseEntity<String> expectResponse = new ResponseEntity<>(Constants.MESSAGE_SUCCESS_CREATE_RESTAURANT, HttpStatus.OK);
        Mockito.when(restaurantServicePort.saveRestaurant(restaurantModel, headers)).thenReturn(expectResponse);

        assertEquals(restaurantHandler.saveRestaurant(restaurantRequestDto, headers), expectResponse);
        verify(restaurantServicePort, times(1)).saveRestaurant(restaurantModel, headers);
    }
}