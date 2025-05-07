package pe.edu.upc.medih.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiagnosticoDTO {
    private int id;

    @JsonProperty("descripcion_diagnostico")
    private String descripcion;

    @JsonProperty("usuario_id")
    private int usuarioId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}