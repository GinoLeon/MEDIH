package pe.edu.upc.medih.dtos;

import java.time.LocalDate;

public class UsuarioListDTO {
    private Long id;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private String telefonoUsuario;
    private LocalDate fechaNacimientoUsuario;
    private String disponibilidadUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public LocalDate getFechaNacimientoUsuario() {
        return fechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(LocalDate fechaNacimientoUsuario) {
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    public String getDisponibilidadUsuario() {
        return disponibilidadUsuario;
    }

    public void setDisponibilidadUsuario(String disponibilidadUsuario) {
        this.disponibilidadUsuario = disponibilidadUsuario;
    }
}
