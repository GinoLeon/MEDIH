package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "Chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatId;

    @Column(name = "Mensaje", length = 1000)
    private String mensaje;

    @Column(name = "FechaEnvio")
    private LocalDateTime fechaEnvio;

    @Column(name = "TipoMensaje", length = 50)
    private String tipoMensaje;

    @ManyToOne
    @JoinColumn(name = "PacienteID", nullable = false)
    private Usuario paciente;

    @ManyToOne
    @JoinColumn(name = "DoctorID", nullable = false)
    private Usuario doctor;

    @Column(name = "Leido", nullable = false)
    private boolean leido;

    public Chat() {
    }

    public Chat(int chatId, String mensaje, LocalDateTime fechaEnvio, String tipoMensaje, Usuario paciente, Usuario doctor, boolean leido) {
        this.chatId = chatId;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.tipoMensaje = tipoMensaje;
        this.paciente = paciente;
        this.doctor = doctor;
        this.leido = leido;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public Usuario getDoctor() {
        return doctor;
    }

    public void setDoctor(Usuario doctor) {
        this.doctor = doctor;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
}
