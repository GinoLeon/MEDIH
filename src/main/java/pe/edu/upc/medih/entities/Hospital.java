package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHospital;

    @Column(name = "nombreHospital", length = 100, nullable = false)
    private String nombreHospital;

    @Column(nullable = false)
    private double latitud;

    @Column(nullable = false)
    private double longitud;

    public Hospital() {
    }

    public Hospital(int idHospital, String nombreHospital, double latitud, double longitud) {
        this.idHospital = idHospital;
        this.nombreHospital = nombreHospital;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
