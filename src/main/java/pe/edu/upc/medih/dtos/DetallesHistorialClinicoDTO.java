package pe.edu.upc.medih.dtos;

public class DetallesHistorialClinicoDTO {
    private int idDetalleHistorial;
    private int idHistorial;
    private int idTratamiento;
    private int idExamen;
    private int idMedicamentoDetalle;
    private int idDiagnostico;

    // Getters y Setters
    public int getIdDetalleHistorial() {
        return idDetalleHistorial;
    }

    public void setIdDetalleHistorial(int idDetalleHistorial) {
        this.idDetalleHistorial = idDetalleHistorial;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public int getIdMedicamentoDetalle() {
        return idMedicamentoDetalle;
    }

    public void setIdMedicamentoDetalle(int idMedicamentoDetalle) {
        this.idMedicamentoDetalle = idMedicamentoDetalle;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }
}