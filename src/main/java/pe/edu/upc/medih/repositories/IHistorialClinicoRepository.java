package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.medih.entities.HistorialClinico;

import java.util.List;

public interface IHistorialClinicoRepository extends JpaRepository<HistorialClinico, Integer> {
       // obitene todos los historiales cloiinicos de un paciente segun id
    @Query("SELECT h FROM HistorialClinico h WHERE h.paciente.id = :pacienteId")
    List<HistorialClinico> findByPacienteId(@Param("pacienteId") Integer pacienteId);
}