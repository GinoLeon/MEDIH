package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Usuario;
import pe.edu.upc.medih.repositories.IUsuarioRepository;
import pe.edu.upc.medih.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uS;

    @Override
    public List<Usuario> list() {
        return uS.findAll();
    }

    @Override
    public void insert(Usuario a) {
        uS.save(a);
    }

    @Override
    public Usuario searchbyId(int id) {
        return uS.findById(id).orElse(new Usuario());
    }

    @Override
    public void update(Usuario a) {
        uS.save(a);
    }

    @Override
    public void delete(int id) {
        uS.deleteById(id);
    }
}
