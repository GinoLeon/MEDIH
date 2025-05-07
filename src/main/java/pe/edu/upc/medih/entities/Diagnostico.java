package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnosticos")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 50) /
    private String estado;

    @Column(name = "fecha", nullable = false)
    private java.time.LocalDateTime fecha;

    // Constructor vacío
    public Diagnostico() {
        this.fecha = java.time.LocalDateTime.now(); // Fecha por defecto
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public java.time.LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(java.time.LocalDateTime fecha) {
        this.fecha = fecha;
    }
}