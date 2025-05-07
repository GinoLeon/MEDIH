package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.medih.entities.Diagnostico;

import java.util.List;

@Repository
public interface IDDiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {

    @Query("SELECT d FROM Diagnostico d WHERE d.descripcion LIKE %:descripcion%")
    List<Diagnostico> findByDescripcionContaining(@Param("descripcion") String descripcion);

    @Query(value = "SELECT * FROM diagnosticos WHERE fecha >= :fecha", nativeQuery = true) // Corregido
    List<Diagnostico> findRecentDiagnosticos(@Param("fecha") String fecha);

    @Transactional
    @Modifying
    @Query("DELETE FROM Diagnostico d WHERE d.estado = :estado") // Ahora funciona correctamente
    void deleteByEstado(@Param("estado") String estado);
}