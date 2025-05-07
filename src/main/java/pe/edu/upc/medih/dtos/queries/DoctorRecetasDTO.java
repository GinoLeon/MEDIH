package pe.edu.upc.medih.dtos.queries;

public class DoctorRecetasDTO {

    private String nombreDoctor;
    private int totalRecetas;

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public int getTotalRecetas() {
        return totalRecetas;
    }

    public void setTotalRecetas(int totalRecetas) {
        this.totalRecetas = totalRecetas;
    }
}
