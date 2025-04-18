package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nameRol", length = 10, nullable = false)
    private String nameRol;

    public Rol() {
    }

    public Rol(int idRol, String nameRol) {
        this.idRol = idRol;
        this.nameRol = nameRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }
}
