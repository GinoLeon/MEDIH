package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.medih.entities.Examen_Medico;

public interface IExamen_MedicoRepository extends JpaRepository<Examen_Medico, Integer> {
}
