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

    @Query("SELECT COUNT(d) FROM Diagnostico d WHERE d.estado = :estado")
    int countByEstado(@Param("estado") String estado);

    @Query(value = "SELECT * FROM diagnostico WHERE fecha_creacion >= :fecha", nativeQuery = true)
    List<Diagnostico> findRecentDiagnosticos(@Param("fecha") String fecha);

    @Transactional
    @Modifyingq
    @Query("DELETE FROM Diagnostico d WHERE d.estado = :estado")
    void deleteByEstado(@Param("estado") String estado);


}