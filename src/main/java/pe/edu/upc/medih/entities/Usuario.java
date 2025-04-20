package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nombreUsuario", length = 15, nullable = false)
    private String nombreUsuario;

    @Column(name = "apellidoUsuario", length = 10, nullable = false)
    private String apellidoUsuario;

    @Column(name = "correoUsuario", length = 25, nullable = false)
    private String correoUsuario;

    @Column(name = "telefonoUsuario", length = 11, nullable = false)
    private String telefonoUsuario;

    @Column(name = "contraseniaUsuario", length = 30, nullable = false)
    private String contraseniaUsuario;

    @Column(name = "fechaNacimientoUsuario", length = 15, nullable = false)
    private String fechaNacimientoUsuario;

    @Column(name = "disponibilidadUsuario", length = 30, nullable = true)
    private String disponibilidadUsuario;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public String getFechaNacimientoUsuario() {
        return fechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(String fechaNacimientoUsuario) {
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    public String getDisponibilidadUsuario() {
        return disponibilidadUsuario;
    }

    public void setDisponibilidadUsuario(String disponibilidadUsuario) {
        this.disponibilidadUsuario = disponibilidadUsuario;
    }

    public Rol getRoles() {
        return rol;
    }

    public void setRoles(Rol rol) {
        this.rol = rol;
    }
}
