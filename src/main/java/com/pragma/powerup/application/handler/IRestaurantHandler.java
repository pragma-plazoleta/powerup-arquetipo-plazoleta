package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.RestaurantRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IRestaurantHandler {

    ResponseEntity<String> saveRestaurant(RestaurantRequestDto restaurantRequestDto, Map<String, String> headers);

}
