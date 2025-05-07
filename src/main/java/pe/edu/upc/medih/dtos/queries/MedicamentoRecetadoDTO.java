package pe.edu.upc.medih.dtos.queries;

public class MedicamentoRecetadoDTO {

    private String nombreMedicamento;
    private int totalRecetas;

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public int getTotalRecetas() {
        return totalRecetas;
    }

    public void setTotalRecetas(int totalRecetas) {
        this.totalRecetas = totalRecetas;
    }
}
