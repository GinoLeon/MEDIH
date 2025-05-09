package pe.edu.upc.medih.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.medih.entities.HistorialClinico;
import pe.edu.upc.medih.entities.Usuario;

import java.util.List;

public interface IHistorialClinicoRepository extends JpaRepository<HistorialClinico, Integer> {
       // obitene todos los historiales cloiinicos de un paciente segun id
    @Query(value = "SELECT * FROM historial_clinico h WHERE id_usuario = :pacienteId",nativeQuery = true)
    List<HistorialClinico> findByPacienteId(@Param("pacienteId") Integer pacienteId);

    @Modifying
    @Transactional
    @Query("UPDATE HistorialClinico h SET h.usuario = :nuevoUsuario WHERE h.usuario.id = :idPaciente")
    void reasignarHistoriales(@Param("nuevoUsuario") Usuario nuevoUsuario, @Param("idPaciente") long idPaciente);

    @Query("SELECT h FROM HistorialClinico h WHERE h.usuario.id = :idPaciente")
    List<HistorialClinico> buscarPorPaciente(@Param("idPaciente") int idPaciente);
}