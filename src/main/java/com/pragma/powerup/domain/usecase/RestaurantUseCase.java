package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.domain.spi.IUserServicePort;
import com.pragma.powerup.domain.util.Constants;
import com.pragma.powerup.domain.validate.DataValidate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

public class RestaurantUseCase implements IRestaurantServicePort {

    private final IUserServicePort userServicePort;
    private final DataValidate dataValidate;
    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IUserServicePort userServicePort, DataValidate dataValidate, IRestaurantPersistencePort restaurantPersistencePort) {
        this.userServicePort = userServicePort;
        this.dataValidate = dataValidate;
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public ResponseEntity<String> saveRestaurant(RestaurantModel restaurantModel, Map<String, String> header) {

        dataValidate.validateDataNotNull(restaurantModel, "id");
        dataValidate.validateOnlyNumbers(restaurantModel.getNit(), "Nit");
        dataValidate.validatePhoneNumber(restaurantModel.getCelular());
        dataValidate.validateNameRestaurant(restaurantModel.getNombre());
        UserModel userModel = userServicePort.getUser(restaurantModel.getIdPropietario(), header);
        restaurantModel.setIdPropietario(String.valueOf(userModel.getId()));

        if (userModel.getNombreRol().equalsIgnoreCase(Constants.ROL_PROPIETARIO)){
            restaurantPersistencePort.saveRestaurant(restaurantModel);
        } else {
            return new ResponseEntity<>(Constants.MESSAGE_ERROR_INVALID_ROL, HttpStatus.PARTIAL_CONTENT);
        }
        return new ResponseEntity<>(Constants.MESSAGE_SUCCESS_CREATE_RESTAURANT, HttpStatus.OK);
    }

}
