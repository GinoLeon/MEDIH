package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Usuario_Especialidad;

import java.util.List;

public interface IUsuario_EspecialidadService {
    public List<Usuario_Especialidad> findAll();
    public void insert(Usuario_Especialidad usuario_especialidad);
    public Usuario_Especialidad searchbyId(int id);
    public void delete(int id);
    public void update(Usuario_Especialidad usuario_especialidad);

}
