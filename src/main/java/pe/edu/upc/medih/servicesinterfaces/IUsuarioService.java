package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario a);

    public Usuario searchbyId(int id);
    public void update(Usuario a);

    public void delete(int id);
}
