package pe.edu.upc.medih.dtos.queries;

public class DoctorRecetasDTO {
    private String nombreDoctor;
    private int CantiadRecetas;

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public int getCantiadRecetas() {
        return CantiadRecetas;
    }

    public void setCantiadRecetas(int cantiadRecetas) {
        CantiadRecetas = cantiadRecetas;
    }
}
