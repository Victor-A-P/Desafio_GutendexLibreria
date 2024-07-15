package com.UPIICSA.desafioLibreria.repository;

import com.UPIICSA.desafioLibreria.model.Autor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long>{

    Optional<Autor> findByNombreIgnoreCase(String nombre);

    //Para saber si el autor se encontrba vivo en dicho año
    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :anio AND a.fechaDeMuerte >= :anio")
    List<Autor> autoresVivosEnUnDeterminadoAnio(@Param("anio") Integer anio);
}
