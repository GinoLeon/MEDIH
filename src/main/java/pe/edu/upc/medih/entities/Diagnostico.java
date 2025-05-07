package pe.edu.upc.medih.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "diagnostico")
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDiagnostico;

    @Column(name = "descripcion",nullable = false,length = 100)
    private String descripcion;

    @Column(name = "fecha",nullable = false)
    private LocalDateTime fecha;

    @Column(name = "estado",nullable = true,length = 100)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idDiagnosticoComparado",nullable = true)
    private Diagnostico diagnosticoComparado;

    public Diagnostico() {
    }

    public Diagnostico(int idDiagnostico, String descripcion, LocalDateTime fecha, String estado, Usuario usuario, Diagnostico diagnosticoComparado) {
        this.idDiagnostico = idDiagnostico;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = usuario;
        this.diagnosticoComparado = diagnosticoComparado;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Diagnostico getDiagnosticoComparado() {
        return diagnosticoComparado;
    }

    public void setDiagnosticoComparado(Diagnostico diagnosticoComparado) {
        this.diagnosticoComparado = diagnosticoComparado;
    }
}