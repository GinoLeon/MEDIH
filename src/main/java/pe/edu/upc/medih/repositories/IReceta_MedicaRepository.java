package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Receta_Medica;

@Repository
public interface IReceta_MedicaRepository extends JpaRepository<Receta_Medica, Integer> {
}