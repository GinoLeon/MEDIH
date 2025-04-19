package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.medih.entities.Especialidad;

public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}
