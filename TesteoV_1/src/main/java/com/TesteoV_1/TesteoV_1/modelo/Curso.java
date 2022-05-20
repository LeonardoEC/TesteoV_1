package com.TesteoV_1.TesteoV_1.modelo;

import javax.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 900, nullable = false)
    private String nombre;

    @Column(name = "lugar", length = 900, nullable = false)
    private String lugar;

    @Column(name = "fechainicio")
    private String fechainicio;

    @Column(name = "fechafin")
    private String fechafin;

    @Column(name = "descripcion", length = 6000, nullable = false)
    private String descripcion;

    @Column(name = "imgUrl", length = 6000)
    private String imgUrl;

    public Curso() {
    }

    public Curso(String nombre, String lugar, String fechainicio, String fechafin, String descripcion, String imgUrl) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
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
}
