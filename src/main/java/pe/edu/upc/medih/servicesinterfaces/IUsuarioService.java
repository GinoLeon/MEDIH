package pe.edu.upc.medih.servicesinterfaces;


import pe.edu.upc.medih.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public  List<String[]> calcularEdad(Long idUsuario);//calcular edad
    public List<Usuario> list();
    public void insert(Usuario a);

    public Usuario searchbyId(Long id);
    public void update(Usuario a);

    public void delete(Long id);

    public List<String[]> ListarCantidadRoles();
}
