package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Usuario;
import pe.edu.upc.medih.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwUsuarioDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findOneByNombreUsuario(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        user.getRol().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNameRol()));
        });

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getNombreUsuario(), user.getContraseniaUsuario(), user.getEnabled(), true, true, true, roles);

        return ud;
    }
}
