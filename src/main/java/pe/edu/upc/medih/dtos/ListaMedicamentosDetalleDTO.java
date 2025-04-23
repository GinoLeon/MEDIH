package pe.edu.upc.medih.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.medih.entities.Medicamento;

public class ListaMedicamentosDetalleDTO {
    private int idMedicamentoDetalle;
    private int idListaMedicamento;
    private Medicamento medicamento;

    public int getIdMedicamentoDetalle() {
        return idMedicamentoDetalle;
    }

    public void setIdMedicamentoDetalle(int idMedicamentoDetalle) {
        this.idMedicamentoDetalle = idMedicamentoDetalle;
    }

    public int getIdListaMedicamento() {
        return idListaMedicamento;
    }

    public void setIdListaMedicamento(int idListaMedicamento) {
        this.idListaMedicamento = idListaMedicamento;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
}
