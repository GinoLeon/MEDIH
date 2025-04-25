package pe.edu.upc.medih.dtos;
import pe.edu.upc.medih.entities.Usuario;
import java.time.LocalDate;

public class Receta_MedicaDTO {
    private int idreceta;
    private int idUsuario;
    private Usuario iddoctor;
    private LocalDate fecha;
    private int idlista_medicamento_detalle;

    public int getIdreceta() {
        return idreceta;
    }

    public void setIdreceta(int idreceta) {
        this.idreceta = idreceta;
    }

    public int getIdlista_medicamento_detalle() {
        return idlista_medicamento_detalle;
    }

    public void setIdlista_medicamento_detalle(int idlista_medicamento_detalle) {
        this.idlista_medicamento_detalle = idlista_medicamento_detalle;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Usuario iddoctor) {
        this.iddoctor = iddoctor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}