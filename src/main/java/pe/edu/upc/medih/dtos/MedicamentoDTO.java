package pe.edu.upc.medih.dtos;

public class MedicamentoDTO {
    private int idMedicamento;
    private String nombreMedicamento;
    private String dosisMedicamento;
    private String fecuenciaMedicamento;

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
