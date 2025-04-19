package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Examen_Medico")
public class Examen_Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExamen;
    @Column(name ="tipoExamen" ,length =25 ,nullable = false)
    private String tipoExamen;

    @Column(name ="rsultadoExamen" ,length =25 ,nullable = false)
    private String rsultadoExamen;

    @Column(name ="fechaExamen" ,length =25 ,nullable = false)
    private String fechaExamen;

    public Examen_Medico() {
    }

    public Examen_Medico(int idExamen, String tipoExamen, String rsultadoExamen, String fechaExamen) {
        this.idExamen = idExamen;
        this.tipoExamen = tipoExamen;
        this.rsultadoExamen = rsultadoExamen;
        this.fechaExamen = fechaExamen;
    }

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
