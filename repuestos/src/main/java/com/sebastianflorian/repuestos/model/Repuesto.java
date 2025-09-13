package com.sebastianflorian.repuestos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "repuesto")
public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRepuesto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria; // Mapeada a la entidad Categoria

    // Getters y setters
    public Integer getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(Integer idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}