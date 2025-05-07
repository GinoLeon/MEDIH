package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

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

    @Column(name = "fechaDeRegistro",length=25,nullable=false)
    private String fechaDeRegistro;

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

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(String fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }
}
