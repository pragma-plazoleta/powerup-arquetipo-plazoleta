package com.pragma.powerup.infrastructure.input.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.pragma.powerup.application.dto.RestaurantRequestDto;
import com.pragma.powerup.application.handler.IRestaurantHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {

    private final IRestaurantHandler restaurantHandler;

    public RestaurantController(IRestaurantHandler restaurantHandler) {
        this.restaurantHandler = restaurantHandler;
    }

    @Operation(summary = "Add a new restaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Restaurant created", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "409", description = "Restaurant already exists", content = @Content)
    })
    @PostMapping("/createRestaurant")
    public ResponseEntity<String> saveRestaurant (@RequestBody RestaurantRequestDto restaurantRequestDto, @RequestHeader Map<String, String> headers) {
        return restaurantHandler.saveRestaurant(restaurantRequestDto, headers);
    }
}
