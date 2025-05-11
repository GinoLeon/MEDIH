package pe.edu.upc.medih.dtos;

import jakarta.persistence.*;
import pe.edu.upc.medih.entities.*;

public class DetallesHistorialClinicoDTO {
    private int idDetalleHistorial;
    private HistorialClinicoDTO historialClinico;
    private Tratamiento tratamiento;
    private Examen_Medico examenMedico;
    private int idListaMedicamento;
    private DiagnosticoDTO Diagnostico;

    public int getIdDetalleHistorial() {
        return idDetalleHistorial;
    }

    public void setIdDetalleHistorial(int idDetalleHistorial) {
        this.idDetalleHistorial = idDetalleHistorial;
    }

    public HistorialClinicoDTO getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(HistorialClinicoDTO historialClinico) {
        this.historialClinico = historialClinico;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Examen_Medico getExamenMedico() {
        return examenMedico;
    }

    public void setExamenMedico(Examen_Medico examenMedico) {
        this.examenMedico = examenMedico;
    }

    public int getIdListaMedicamento() {
        return idListaMedicamento;
    }

    public void setIdListaMedicamento(int idListaMedicamento) {
        this.idListaMedicamento = idListaMedicamento;
    }

    public DiagnosticoDTO getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(DiagnosticoDTO diagnostico) {
        Diagnostico = diagnostico;
    }
}