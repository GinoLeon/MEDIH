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
    private Tratamiento idTratamiento;

    @ManyToOne
    @JoinColumn(name = "id_examen", nullable = false)
    private Examen_Medico examenMedico;

    @ManyToOne
    @JoinColumn(name = "idListaMedicamento", nullable = false)
    private ListaMedicamentosDetalle medicamentoDetalle;

    @ManyToOne
    @JoinColumn(name = "idDiagnostico", nullable = false)
    private Diagnostico idDiagnostico;

    public DetallesHistorialClinico() {
    }

    public DetallesHistorialClinico(int idDetalleHistorial, HistorialClinico historialClinico, Tratamiento idTratamiento, Examen_Medico examenMedico, ListaMedicamentosDetalle medicamentoDetalle, Diagnostico idDiagnostico) {
        this.idDetalleHistorial = idDetalleHistorial;
        this.historialClinico = historialClinico;
        this.idTratamiento = idTratamiento;
        this.examenMedico = examenMedico;
        this.medicamentoDetalle = medicamentoDetalle;
        this.idDiagnostico = idDiagnostico;
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

    public Tratamiento getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Tratamiento idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Examen_Medico getExamenMedico() {
        return examenMedico;
    }

    public void setExamenMedico(Examen_Medico examenMedico) {
        this.examenMedico = examenMedico;
    }

    public ListaMedicamentosDetalle getMedicamentoDetalle() {
        return medicamentoDetalle;
    }

    public void setMedicamentoDetalle(ListaMedicamentosDetalle medicamentoDetalle) {
        this.medicamentoDetalle = medicamentoDetalle;
    }

    public Diagnostico getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Diagnostico idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }
}