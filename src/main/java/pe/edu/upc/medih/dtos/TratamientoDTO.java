package pe.edu.upc.medih.dtos;

import java.time.LocalDate;

public class TratamientoDTO {

    private int idTratamiento;
    private String TipoTratamiento;
    private LocalDate FechaInicio;
    private LocalDate FechaFin;

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
    }

    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getTipoTratamiento() {
        return TipoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        TipoTratamiento = tipoTratamiento;
    }
}
