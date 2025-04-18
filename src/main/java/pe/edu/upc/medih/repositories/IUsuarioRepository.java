package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.medih.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
