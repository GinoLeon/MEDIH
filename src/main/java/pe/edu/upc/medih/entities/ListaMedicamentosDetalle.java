package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ListaMedicamentosDetalle")
public class ListaMedicamentosDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedicamentoDetalle;

    @Column(name = "idListaMedicamento",nullable = false)
    private int idListaMedicamento;

    @ManyToOne
    @JoinColumn(name = "idMedicamento",nullable = false)
    private Medicamento medicamento;

    public ListaMedicamentosDetalle() {
    }

    public ListaMedicamentosDetalle(int idMedicamentoDetalle, int idListaMedicamento, Medicamento medicamento) {
        this.idMedicamentoDetalle = idMedicamentoDetalle;
        this.idListaMedicamento = idListaMedicamento;
        this.medicamento = medicamento;
    }

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
