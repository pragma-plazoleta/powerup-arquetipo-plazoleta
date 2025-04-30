package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.DummyMock;
import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.domain.spi.IUserServicePort;
import com.pragma.powerup.domain.util.Constants;
import com.pragma.powerup.domain.validate.DataValidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestaurantUseCaseTest {

    private IUserServicePort userServicePort;
    private IRestaurantPersistencePort restaurantPersistencePort;
    private DataValidate dataValidate;
    private RestaurantUseCase restaurantUseCase;
    private DummyMock dummyMock;


    @BeforeEach
    void setUp() {
        userServicePort = mock(IUserServicePort.class);
        restaurantPersistencePort = mock(IRestaurantPersistencePort.class);
        dataValidate = mock(DataValidate.class);
        restaurantUseCase = new RestaurantUseCase(userServicePort, dataValidate, restaurantPersistencePort);
        dummyMock = new DummyMock();
    }

    @Test
    void saveRestaurant_shouldReturnOkWhenUserIsPropietario() {
        Map<String, String> header = new HashMap<>();;
        header.put("Authorization", "Bearer test-token");

        when(userServicePort.getUser(dummyMock.getRestaurantModel().getIdPropietario(), header)).thenReturn(dummyMock.getUserModelPropietario());

        ResponseEntity<String> response = restaurantUseCase.saveRestaurant(dummyMock.getRestaurantModel(), header);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Constants.MESSAGE_SUCCESS_CREATE_RESTAURANT, response.getBody());
    }

    @Test
    void saveRestaurant_shouldReturnPartialContentWhenUserIsNotPropietario() {
        UserModel userModel = new UserModel();
        Map<String, String> header = new HashMap<>();;
        header.put("Authorization", "Bearer test-token");

        userModel.setNombreRol("CLIENTE");
        when(userServicePort.getUser(dummyMock.getRestaurantModel().getIdPropietario(), header)).thenReturn(userModel);

        ResponseEntity<String> response = restaurantUseCase.saveRestaurant(dummyMock.getRestaurantModel(), header);

        assertEquals(HttpStatus.PARTIAL_CONTENT, response.getStatusCode());
        assertEquals(Constants.MESSAGE_ERROR_INVALID_ROL, response.getBody());
    }
}
