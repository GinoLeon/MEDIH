package pe.edu.upc.medih.servicesinterfaces;


import pe.edu.upc.medih.dtos.UsuarioDTO;
import pe.edu.upc.medih.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public  List<String[]> calcularEdad(Long idUsuario);//calcular edad
    public List<Usuario> list();
    public void insert(Usuario a);

    public Usuario searchbyId(Long id);

    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO);

    public void delete(Long id);

    public List<String[]> ListarCantidadRoles();
}
