package pe.edu.upc.medih.dtos;

import pe.edu.upc.medih.entities.Usuario;

import java.time.LocalDateTime;

public class Cita_MedicaDTO {

    private int id_cita;
    private int id_usuario;
    private Usuario id_doctor;
    private LocalDateTime fecha;
    private String motivo;
    private String estado;

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Usuario getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Usuario id_doctor) {
        this.id_doctor = id_doctor;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
