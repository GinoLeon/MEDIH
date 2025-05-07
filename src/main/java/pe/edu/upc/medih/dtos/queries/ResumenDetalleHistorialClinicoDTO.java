package pe.edu.upc.medih.dtos.queries;

import java.time.LocalDate;

public class ResumenDetalleHistorialClinicoDTO {
    public int idDetalleHistorial;
    public String FechaRegistro;
    public String nombreUsuario;
    public String tipoTratamiento;
    public String fechaInicio;
    public String fechaFin;
    public String tipoExamen;
    public String resultadoExamen;
    public String fechaExamen;
    public String nombreMedicamento;
    public String DescripcionMedicamento;

    public int getIdDetalleHistorial() {
        return idDetalleHistorial;
    }

    public void setIdDetalleHistorial(int idDetalleHistorial) {
        this.idDetalleHistorial = idDetalleHistorial;
    }

    public String getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        FechaRegistro = fechaRegistro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public String getResultadoExamen() {
        return resultadoExamen;
    }

    public void setResultadoExamen(String resultadoExamen) {
        this.resultadoExamen = resultadoExamen;
    }

    public String getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(String fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getDescripcionMedicamento() {
        return DescripcionMedicamento;
    }

    public void setDescripcionMedicamento(String descripcionMedicamento) {
        DescripcionMedicamento = descripcionMedicamento;
    }
}
