package pe.edu.upc.medih.dtos;


import java.time.LocalDate;

public class DiagnosticoDTO {
    private int idDiagnostico;
    private String descripcion;
    private LocalDate fecha;
    private String estado;
    private Long usuarioId;
    private Integer idDiagnosticoComparado;

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getIdDiagnosticoComparado() {
        return idDiagnosticoComparado;
    }

    public void setIdDiagnosticoComparado(Integer idDiagnosticoComparado) {
        this.idDiagnosticoComparado = idDiagnosticoComparado;
    }
}