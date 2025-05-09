package pe.edu.upc.medih.dtos;

import java.time.LocalDate;

public class Receta_MedicaInsertDTO {
    private int idreceta;
    private Long idUsuario;
    private Long idDoctor;
    private LocalDate fecha;
    private int idListaMedicamentoDetalle;

    public int getIdreceta() {
        return idreceta;
    }

    public void setIdreceta(int idreceta) {
        this.idreceta = idreceta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
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
