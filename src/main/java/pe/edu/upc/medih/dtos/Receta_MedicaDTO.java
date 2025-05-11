package pe.edu.upc.medih.dtos;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.medih.entities.Usuario;

import java.time.LocalDate;

public class Receta_MedicaDTO {

    private int idReceta;
    private UsuarioListDTO usuario;
    private UsuarioListDTO doctor;
    private LocalDate fecha;
    private int idListaMedicamentoDetalle;

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public UsuarioListDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioListDTO usuario) {
        this.usuario = usuario;
    }

    public UsuarioListDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(UsuarioListDTO doctor) {
        this.doctor = doctor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdListaMedicamentoDetalle() {
        return idListaMedicamentoDetalle;
    }

    public void setIdListaMedicamentoDetalle(int idListaMedicamentoDetalle) {
        this.idListaMedicamentoDetalle = idListaMedicamentoDetalle;
    }
}