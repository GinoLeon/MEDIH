package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Medicamento;

@Repository
public interface IMedicamentosRepository extends JpaRepository<Medicamento, Integer> {
}
