package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Especialidad;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}
