package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedicamento;
    @Column(name = "nombreMedicamento", length = 25, nullable = false)
    private String nombreMedicamento;

    @Column(name = "dosisMedicamento", length = 25, nullable = false)
    private String dosisMedicamento;

    @Column(name = "fecuenciaMedicamento", length = 20, nullable = false)
    private String fecuenciaMedicamento;

    public Medicamento() {
    }

    public Medicamento(String fecuenciaMedicamento, String dosisMedicamento, String nombreMedicamento, int idMedicamento) {
        this.fecuenciaMedicamento = fecuenciaMedicamento;
        this.dosisMedicamento = dosisMedicamento;
        this.nombreMedicamento = nombreMedicamento;
        this.idMedicamento = idMedicamento;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getDosisMedicamento() {
        return dosisMedicamento;
    }

    public void setDosisMedicamento(String dosisMedicamento) {
        this.dosisMedicamento = dosisMedicamento;
    }

    public String getFecuenciaMedicamento() {
        return fecuenciaMedicamento;
    }

    public void setFecuenciaMedicamento(String fecuenciaMedicamento) {
        this.fecuenciaMedicamento = fecuenciaMedicamento;
    }
}
