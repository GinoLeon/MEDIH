package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DetallesHistorialClinico")
public class DetallesHistorialClinico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleHistorial;

    @ManyToOne
    @JoinColumn(name = "id_historial", nullable = false)
    private HistorialClinico historialClinico;

    @ManyToOne
    @JoinColumn(name = "id_Tratamiento", nullable = false)
    private Tratamiento tratamiento;

    @ManyToOne
    @JoinColumn(name = "id_examen", nullable = false)
    private Examen_Medico examenMedico;


    @Column(name = "idListaMedicamento",nullable = false)
    private int idListaMedicamento;

    @ManyToOne
    @JoinColumn(name = "idDiagnostico", nullable = false)
    private Diagnostico Diagnostico;

    public DetallesHistorialClinico() {
    }

    public DetallesHistorialClinico(int idDetalleHistorial, HistorialClinico historialClinico, Tratamiento tratamiento, Examen_Medico examenMedico, int idListaMedicamento, Diagnostico diagnostico) {
        this.idDetalleHistorial = idDetalleHistorial;
        this.historialClinico = historialClinico;
        this.tratamiento = tratamiento;
        this.examenMedico = examenMedico;
        this.idListaMedicamento = idListaMedicamento;
        Diagnostico = diagnostico;
    }

    public int getIdDetalleHistorial() {
        return idDetalleHistorial;
    }

    public void setIdDetalleHistorial(int idDetalleHistorial) {
        this.idDetalleHistorial = idDetalleHistorial;
    }

    public HistorialClinico getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(HistorialClinico historialClinico) {
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

    public Diagnostico getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        Diagnostico = diagnostico;
    }
}