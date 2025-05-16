package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Diagnostico;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IDDiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {
    public List<Diagnostico> findByDescripcionContaining(String descripcion);

    @Query(value = "SELECT * FROM diagnostico WHERE fecha >= :fecha", nativeQuery = true)
    public List<Diagnostico> findRecentDiagnosticos(@Param("fecha") LocalDate fecha);

}