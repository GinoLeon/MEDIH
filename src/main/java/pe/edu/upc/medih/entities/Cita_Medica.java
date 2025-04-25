package pe.edu.upc.medih.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CitasMedicas")
public class Cita_Medica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cita;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private Usuario doctor;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "motivo", columnDefinition = "TEXT")
    private String motivo;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    public Cita_Medica() {
    }

    public Cita_Medica(int id_cita, Usuario usuario, Usuario doctor, LocalDateTime fecha, String motivo, String estado) {
        this.id_cita = id_cita;
        this.usuario = usuario;
        this.doctor = doctor;
        this.fecha = fecha;
        this.motivo = motivo;
        this.estado = estado;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getDoctor() {
        return doctor;
    }

    public void setDoctor(Usuario doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}