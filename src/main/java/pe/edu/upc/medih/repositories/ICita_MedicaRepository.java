package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.medih.entities.Cita_Medica;

import java.util.List;

public interface ICita_MedicaRepository extends JpaRepository<Cita_Medica, Integer> {
    // Custom query to find Cita_Medica by estado
    @Query("SELECT c FROM Cita_Medica c WHERE c.estado = :estado")
    public List<Cita_Medica> findByEstado(@Param("estado") String estado);
}