package com.pragma.powerup.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String numeroDocumento;
    private String celular;
    private String correo;
    private String nombreRol;

}
