package pe.edu.upc.medih.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HistorialClinicoDTO {

    private int idHistorial;
    private int idUsuario;
    private LocalDate fechaRegistro;

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
