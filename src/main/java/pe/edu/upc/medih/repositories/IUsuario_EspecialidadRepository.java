package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Usuario_Especialidad;

@Repository
public interface IUsuario_EspecialidadRepository extends JpaRepository<Usuario_Especialidad, Integer> {
}
