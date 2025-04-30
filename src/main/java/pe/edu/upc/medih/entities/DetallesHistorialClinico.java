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

    @Column(name = "id_tratamiento", nullable = false)
    private int idTratamiento;

    @ManyToOne
    @JoinColumn(name = "id_examen", nullable = false)
    private Examen_Medico examenMedico;

    @ManyToOne
    @JoinColumn(name = "id_medicamento_detalle", nullable = false)
    private ListaMedicamentosDetalle medicamentoDetalle;

    @Column(name = "id_diagnostico", nullable = false)
    private int idDiagnostico;

    public DetallesHistorialClinico() {
    }

    // Getters y Setters
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

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
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

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }
}