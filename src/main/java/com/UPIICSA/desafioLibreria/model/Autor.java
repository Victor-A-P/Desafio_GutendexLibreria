package com.UPIICSA.desafioLibreria.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private Integer fechaDeNacimiento;
    private Integer fechaDeMuerte;


    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(DatosAutor datosAuthor) {
        this.nombre = datosAuthor.nombre();
        this.fechaDeNacimiento = datosAuthor.fechaDeNacimiento();
        this.fechaDeMuerte = datosAuthor.fechaDeMuerte();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeMuerte() {
        return fechaDeMuerte;
    }

    public void setFechaDeMuerte(Integer fechaDeMuerte) {
        this.fechaDeMuerte = fechaDeMuerte;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("-----------------");
        sb.append("Autor: ").append(nombre).append("\n")
                .append("Fecha de nacimiento: ").append(fechaDeNacimiento).append("\n")
                .append("Fecha de muerte: ").append(fechaDeMuerte).append("\n")
                .append("Libros: ").append("\n");
        for (Libro libro : libros) {
            sb.append("-  ").append(libro.getTitulo()).append("\n");
        }
        return sb.toString();
    }
}