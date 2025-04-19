package pe.edu.upc.medih.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Examen_MedicoDTO {
    private int idExamen;
    private String tipoExamen;
    private String rsultadoExamen;
    private String fechaExamen;

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public String getRsultadoExamen() {
        return rsultadoExamen;
    }

    public void setRsultadoExamen(String rsultadoExamen) {
        this.rsultadoExamen = rsultadoExamen;
    }

    public String getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(String fechaExamen) {
        this.fechaExamen = fechaExamen;
    }
}
