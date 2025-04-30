package com.pragma.powerup.application.mapper.request;

import com.pragma.powerup.application.dto.RestaurantRequestDto;
import com.pragma.powerup.domain.model.RestaurantModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T17:32:14-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 11.0.25 (Oracle Corporation)"
)
@Component
public class IRestaurantRequestMapperImpl implements IRestaurantRequestMapper {

    @Override
    public RestaurantModel toModel(RestaurantRequestDto restaurantRequestDto) {
        if ( restaurantRequestDto == null ) {
            return null;
        }

        RestaurantModel restaurantModel = new RestaurantModel();

        restaurantModel.setNombre( restaurantRequestDto.getNombre() );
        restaurantModel.setDireccion( restaurantRequestDto.getDireccion() );
        if ( restaurantRequestDto.getIdPropietario() != null ) {
            restaurantModel.setIdPropietario( String.valueOf( restaurantRequestDto.getIdPropietario() ) );
        }
        restaurantModel.setCelular( restaurantRequestDto.getCelular() );
        restaurantModel.setUrlLogo( restaurantRequestDto.getUrlLogo() );
        restaurantModel.setNit( restaurantRequestDto.getNit() );

        return restaurantModel;
    }
}
