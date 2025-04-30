package pe.edu.upc.medih.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Examen_Medico")
public class Examen_Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExamen;
    @Column(name ="tipoExamen" ,length =50 ,nullable = false)
    private String tipoExamen;

    @Column(name ="resultadoExamen" ,length =100 ,nullable = false)
    private String resultadoExamen;

    @Column(name ="fechaExamen" ,length =30 ,nullable = false)
    private String fechaExamen;

    public Examen_Medico() {
    }

    public Examen_Medico(int idExamen, String tipoExamen, String resultadoExamen, String fechaExamen) {
        this.idExamen = idExamen;
        this.tipoExamen = tipoExamen;
        this.resultadoExamen = resultadoExamen;
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

    public String getResultadoExamen() {
        return resultadoExamen;
    }

    public void setResultadoExamen(String resultadoExamen) {
        this.resultadoExamen = resultadoExamen;
    }

    public String getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(String fechaExamen) {
        this.fechaExamen = fechaExamen;
    }
}
