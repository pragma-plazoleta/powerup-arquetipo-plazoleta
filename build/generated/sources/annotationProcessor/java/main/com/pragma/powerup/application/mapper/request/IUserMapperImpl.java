package com.pragma.powerup.application.mapper.request;

import com.pragma.powerup.application.dto.UserResponseDto;
import com.pragma.powerup.domain.model.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T23:42:28-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 11.0.25 (Oracle Corporation)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserModel toModel(UserResponseDto userResponseDto) {
        if ( userResponseDto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userResponseDto.getId() );
        userModel.setNombre( userResponseDto.getNombre() );
        userModel.setApellido( userResponseDto.getApellido() );
        userModel.setNumeroDocumento( userResponseDto.getNumeroDocumento() );
        userModel.setCelular( userResponseDto.getCelular() );
        userModel.setCorreo( userResponseDto.getCorreo() );
        userModel.setNombreRol( userResponseDto.getNombreRol() );

        return userModel;
    }
}
