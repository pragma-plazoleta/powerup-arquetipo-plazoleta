package com.pragma.powerup.infrastructure.out.jpa.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "restaurantes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RestaurantEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String direccion;

    @Column(name = "id_propietario" )
    private Long idPropietario;

    @Column(length = 14)
    private String celular;

    @Column(name = "url_logo", length = 200)
    private String urlLogo;

    @Column(length = 45)
    private String nit;

}
