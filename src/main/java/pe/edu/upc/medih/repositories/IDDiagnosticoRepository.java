package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Diagnostico;

import java.util.List;

@Repository
public interface IDDiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {
    List<Diagnostico> findByDescripcionContaining(String descripcion);

    @Query(value = "SELECT * FROM diagnostico WHERE fecha >= :fecha", nativeQuery = true)
    List<Diagnostico> findRecentDiagnosticos(String fecha);

    void deleteByEstado(String estado);
}