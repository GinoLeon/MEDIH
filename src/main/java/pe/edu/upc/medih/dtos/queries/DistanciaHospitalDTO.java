package pe.edu.upc.medih.dtos.queries;

public class DistanciaHospitalDTO {
    private String nombreHospital;
    private String Distancia_km;

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public String getDistancia_km() {
        return Distancia_km;
    }

    public void setDistancia_km(String distancia_km) {
        Distancia_km = distancia_km;
    }
}
