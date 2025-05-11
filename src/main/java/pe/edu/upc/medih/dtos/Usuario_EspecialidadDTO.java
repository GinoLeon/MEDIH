package pe.edu.upc.medih.dtos;

import pe.edu.upc.medih.entities.Especialidad;

import java.time.LocalDate;

public class Usuario_EspecialidadDTO {
    private int idUsuarioEspecialidad;
    private UsuarioListDTO usuario;
    private Especialidad especialidad;
    private LocalDate fechaDeRegistro;

    public int getIdUsuarioEspecialidad() {
        return idUsuarioEspecialidad;
    }

    public void setIdUsuarioEspecialidad(int idUsuarioEspecialidad) {
        this.idUsuarioEspecialidad = idUsuarioEspecialidad;
    }

    public UsuarioListDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioListDTO usuario) {
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
