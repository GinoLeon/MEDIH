package pe.edu.upc.medih.servicesimplements;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.dtos.UsuarioDTO;
import pe.edu.upc.medih.entities.Rol;
import pe.edu.upc.medih.entities.Usuario;
import pe.edu.upc.medih.repositories.IUsuarioRepository;
import pe.edu.upc.medih.servicesinterfaces.IUsuarioService;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uS;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> list() {
        return uS.findAll();
    }

    @Override
    public void insert(Usuario a) {
        a.setId(null);
        a.setContraseniaUsuario(passwordEncoder.encode(a.getContraseniaUsuario()));
        uS.save(a);
    }

    @Override
    public Usuario searchbyId(Long id) {
        return uS.findById(id).orElse(new Usuario());
    }

    @Override
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = uS.findById(id).get();

        // Actualiza los datos básicos
        usuarioExistente.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuarioExistente.setApellidoUsuario(usuarioDTO.getApellidoUsuario());
        usuarioExistente.setCorreoUsuario(usuarioDTO.getCorreoUsuario());
        usuarioExistente.setTelefonoUsuario(usuarioDTO.getTelefonoUsuario());
        usuarioExistente.setContraseniaUsuario(usuarioDTO.getContraseniaUsuario());
        usuarioExistente.setFechaNacimientoUsuario(usuarioDTO.getFechaNacimientoUsuario());
        usuarioExistente.setDisponibilidadUsuario(usuarioDTO.getDisponibilidadUsuario());

        // Si estás actualizando roles:
        if (usuarioDTO.getRoles() != null) {
            List<Rol> nuevosRoles = usuarioDTO.getRoles().stream()
                    .map(rolDTO -> {
                        Rol rol = new Rol();
                        rol.setIdRol(rolDTO.getIdRol()); // cuidado: si el rol ya existe, usa el mismo ID
                        rol.setNameRol(rolDTO.getNameRol());
                        rol.setUser(usuarioExistente); // muy importante para evitar inconsistencias
                        return rol;
                    }).collect(Collectors.toList());

            usuarioExistente.setRol(nuevosRoles);
        }

        Usuario usuarioActualizado = uS.save(usuarioExistente);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuarioExistente, UsuarioDTO.class);
    }


    @Override
    public void delete(Long id) {
        uS.deleteById(id);
    }

    @Override
    public List<String[]> ListarCantidadRoles() {
        return uS.ListarCantidadRoles();
    }

    //calcular edad
    @Override
    public List<String[]> calcularEdad(Long idUsuario) {
        return uS.calcularEdad(idUsuario);
    }
}
