package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.ListaMedicamentosDetalle;

@Repository
public interface IListaMedicamentosDetalleRepository extends JpaRepository<ListaMedicamentosDetalle, Integer> {
}
