package com.pragma.powerup.application.mapper.request;

import com.pragma.powerup.application.dto.RestaurantRequestDto;
import com.pragma.powerup.domain.model.RestaurantModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantRequestMapper {

    RestaurantModel toModel(RestaurantRequestDto restaurantRequestDto);

}
