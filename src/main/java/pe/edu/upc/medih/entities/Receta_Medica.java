package pe.edu.upc.medih.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "RecetasMedicas")
public class Receta_Medica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReceta;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private Usuario doctor;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "id_lista_medicamento_detalle", nullable = false)
    private int idListaMedicamentoDetalle;

    // Constructores
    public Receta_Medica() {
    }

    public Receta_Medica(int idReceta, Usuario usuario, Usuario doctor, LocalDate fecha, int idListaMedicamentoDetalle) {
        this.idReceta = idReceta;
        this.usuario = usuario;
        this.doctor = doctor;
        this.fecha = fecha;
        this.idListaMedicamentoDetalle = idListaMedicamentoDetalle;
    }

    // Getters y Setters
    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getDoctor() {
        return doctor;
    }

    public void setDoctor(Usuario doctor) {
        this.doctor = doctor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdListaMedicamentoDetalle() {
        return idListaMedicamentoDetalle;
    }

    public void setIdListaMedicamentoDetalle(int idListaMedicamentoDetalle) {
        this.idListaMedicamentoDetalle = idListaMedicamentoDetalle;
    }
}