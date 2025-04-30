package com.pragma.powerup.infrastructure.out.jpa.mapper;

import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.infrastructure.out.jpa.entity.RestaurantEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-29T00:01:39-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 11.0.25 (Oracle Corporation)"
)
@Component
public class IRestaurantEntityMapperImpl implements IRestaurantEntityMapper {

    @Override
    public RestaurantModel toModel(RestaurantEntity restaurantEntity) {
        if ( restaurantEntity == null ) {
            return null;
        }

        RestaurantModel restaurantModel = new RestaurantModel();

        restaurantModel.setId( restaurantEntity.getId() );
        restaurantModel.setNombre( restaurantEntity.getNombre() );
        restaurantModel.setDireccion( restaurantEntity.getDireccion() );
        if ( restaurantEntity.getIdPropietario() != null ) {
            restaurantModel.setIdPropietario( String.valueOf( restaurantEntity.getIdPropietario() ) );
        }
        restaurantModel.setCelular( restaurantEntity.getCelular() );
        restaurantModel.setUrlLogo( restaurantEntity.getUrlLogo() );
        restaurantModel.setNit( restaurantEntity.getNit() );

        return restaurantModel;
    }

    @Override
    public RestaurantEntity toEntity(RestaurantModel restaurantModel) {
        if ( restaurantModel == null ) {
            return null;
        }

        RestaurantEntity restaurantEntity = new RestaurantEntity();

        restaurantEntity.setId( restaurantModel.getId() );
        restaurantEntity.setNombre( restaurantModel.getNombre() );
        restaurantEntity.setDireccion( restaurantModel.getDireccion() );
        if ( restaurantModel.getIdPropietario() != null ) {
            restaurantEntity.setIdPropietario( Long.parseLong( restaurantModel.getIdPropietario() ) );
        }
        restaurantEntity.setCelular( restaurantModel.getCelular() );
        restaurantEntity.setUrlLogo( restaurantModel.getUrlLogo() );
        restaurantEntity.setNit( restaurantModel.getNit() );

        return restaurantEntity;
    }
}
