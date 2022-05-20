package com.TesteoV_1.TesteoV_1.modelo;

import javax.persistence.*;

@Entity
@Table(name = "trabajos")
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 900, nullable = false)
    private String nombre;

    @Column(name = "puesto", length = 900, nullable = false)
    private String puesto;

    @Column(name = "descripcion", length = 6000)
    private String descripcion;

    @Column(name = "imgUrl", length = 6000)
    private String imgUrl;

    //referencias

    @Column(name = "empleador", length = 900, nullable = false)
    private String empleador;

    @Column(name = "telefono", length = 900)
    private String telefono;


    public Trabajo() {
    }

    public Trabajo(String nombre, String puesto, String descripcion, String imgUrl, String empleador, String telefono) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
        this.empleador = empleador;
        this.telefono = telefono;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getEmpleador() {
        return empleador;
    }

    public void setEmpleador(String empleador) {
        this.empleador = empleador;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
