package pe.edu.upc.medih.servicesimplements;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Usuario;
import pe.edu.upc.medih.repositories.IUsuarioRepository;
import pe.edu.upc.medih.servicesinterfaces.IUsuarioService;
import java.util.List;

@Slf4j
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
        log.info("Insertando usuario");
        if (a==null||a.getNombreUsuario()==null||a.getApellidoUsuario()==null||a.getCorreoUsuario()==null||a.getContraseniaUsuario()==null||
        a.getFechaNacimientoUsuario()==null||a.getTelefonoUsuario()==null||a.getDisponibilidadUsuario()==null) {
            log.warn("⚠️ Datos incompletos o incorrectos para el registro del Usuario");
        }
        uS.save(a);
        log.info("Usuario registrado correctamente");
    }

    @Override
    public Usuario searchbyId(long id) {
        return uS.findById(id).orElse(new Usuario());
    }

    @Override
    public void update(Usuario a) {
        uS.save(a);
    }

    @Override
    public void delete(long id) {
        uS.deleteById(id);
    }

    @Override
    public List<String[]> ListarCantidadRoles() {
        return uS.ListarCantidadRoles();
    }
}
