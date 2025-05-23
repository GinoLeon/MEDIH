package pe.edu.upc.medih.dtos;

import pe.edu.upc.medih.entities.Usuario;

public class RolDTO {
    private Long idRol;
    private String nameRol;
    private UsuarioListDTO user;

    public UsuarioListDTO getUser() {
        return user;
    }

    public void setUser(UsuarioListDTO user) {
        this.user = user;
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
