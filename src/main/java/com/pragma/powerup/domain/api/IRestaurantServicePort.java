package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.RestaurantModel;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IRestaurantServicePort {

    ResponseEntity<String> saveRestaurant(RestaurantModel restaurantModel, Map<String, String> header);

}
