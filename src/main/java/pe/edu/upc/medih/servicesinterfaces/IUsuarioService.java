package pe.edu.upc.medih.servicesinterfaces;


import pe.edu.upc.medih.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public int calcularEdad(long idUsuario);//calcular edad
    public List<Usuario> list();
    public void insert(Usuario a);

    public Usuario searchbyId(long id);
    public void update(Usuario a);

    public void delete(long id);

    public List<String[]> ListarCantidadRoles();
}
