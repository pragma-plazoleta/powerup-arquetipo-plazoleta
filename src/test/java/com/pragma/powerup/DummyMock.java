package com.pragma.powerup;

import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.model.UserModel;
import com.pragma.powerup.domain.util.Constants;

public class DummyMock {

    private RestaurantModel restaurantModel;
    private UserModel userModel;

    public RestaurantModel getRestaurantModel() {
        Long id = 1L;
        String nombre = "juan";
        String direccion = "calle 1 # 15 50";
        String idPropietario = "1019001002";
        String celular = "+573192192505";
        String urlLogo = "juan@gmail.com";
        String nit = "222222";
        return new RestaurantModel(id, nombre, direccion,idPropietario, celular, urlLogo, nit);
    }

    public UserModel getUserModelPropietario() {
        Long id = 99L;
        String apellido = "Ruiz";
        String celular = "+573192192505";
        String correo = "juan@gmail.com";
        String nombre = "Juan";
        String numeroDocumento = "1019001002";
        String nombreRol = Constants.ROL_PROPIETARIO;
        return new UserModel(id, nombre, apellido, numeroDocumento, celular, correo, nombreRol);
    }


}
