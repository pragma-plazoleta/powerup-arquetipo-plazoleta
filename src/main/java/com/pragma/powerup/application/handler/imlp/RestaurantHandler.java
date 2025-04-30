package com.pragma.powerup.application.handler.imlp;

import com.pragma.powerup.application.dto.RestaurantRequestDto;
import com.pragma.powerup.application.handler.IRestaurantHandler;
import com.pragma.powerup.application.mapper.request.IRestaurantRequestMapper;
import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.model.RestaurantModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class RestaurantHandler implements IRestaurantHandler {

    private final IRestaurantRequestMapper restaurantRequestMapper;
    private final IRestaurantServicePort restaurantServicePort;

    public RestaurantHandler(IRestaurantRequestMapper restaurantRequestMapper, IRestaurantServicePort restaurantServicePort) {
        this.restaurantRequestMapper = restaurantRequestMapper;
        this.restaurantServicePort = restaurantServicePort;
    }

    @Override
    public ResponseEntity<String> saveRestaurant(RestaurantRequestDto restaurantRequestDto, Map<String, String> header) {
        RestaurantModel restaurantModel = restaurantRequestMapper.toModel(restaurantRequestDto);
        return restaurantServicePort.saveRestaurant(restaurantModel, header);
    }
}
