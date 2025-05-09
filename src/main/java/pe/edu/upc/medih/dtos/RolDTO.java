package pe.edu.upc.medih.dtos;

import pe.edu.upc.medih.entities.Usuario;

public class RolDTO {
    private Long idRol;
    private String nameRol;
    private Usuario userId;

    public Usuario getUserId() {
        return userId;
    }

    public void setUserId(Usuario userId) {
        this.userId = userId;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }
}
