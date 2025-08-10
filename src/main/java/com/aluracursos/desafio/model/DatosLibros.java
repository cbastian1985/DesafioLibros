package com.aluracursos.desafio.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Pages") Integer paginas,
        @JsonAlias("Year") Integer anio
) {
    public String getAutor(){
        return "Stephen king";
    }
}
