package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnosticos") // Asegúrate de que la tabla exista en la base de datos
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descripcion", nullable = false, length = 100) // Verifica que la columna exista en la tabla
    private String descripcion;

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
}