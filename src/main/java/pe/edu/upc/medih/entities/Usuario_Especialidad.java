package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Usuario_Especialidad")
public class Usuario_Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuarioEspecialidad;
    @ManyToOne
    @JoinColumn(name="idUsuario",nullable=false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="idEspecialidad",nullable=false)
    private Especialidad especialidad;

    @Column(name = "fechaDeRegistro",nullable=false)
    private LocalDate fechaDeRegistro;

    public int getIdUsuarioEspecialidad() {
        return idUsuarioEspecialidad;
    }

    public void setIdUsuarioEspecialidad(int idUsuarioEspecialidad) {
        this.idUsuarioEspecialidad = idUsuarioEspecialidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(LocalDate fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }
}
