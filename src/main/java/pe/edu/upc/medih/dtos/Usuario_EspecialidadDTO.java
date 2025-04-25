package pe.edu.upc.medih.dtos;

import pe.edu.upc.medih.entities.Especialidad;
import pe.edu.upc.medih.entities.Usuario;

public class Usuario_EspecialidadDTO {
    private int idUsuarioEspecialidad;
    private Usuario usuario;
    private Especialidad especialidad;
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
