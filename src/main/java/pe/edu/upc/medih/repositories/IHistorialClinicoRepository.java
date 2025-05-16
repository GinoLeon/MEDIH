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

    @Query(value = "SELECT * FROM historial_clinico h WHERE id_usuario = :pacienteId",nativeQuery = true)
    public List<HistorialClinico> findByPacienteId(@Param("pacienteId") Integer pacienteId);


    @Query("SELECT h FROM HistorialClinico h WHERE h.usuario.id = :idPaciente")
    public List<HistorialClinico> buscarPorPaciente(@Param("idPaciente") int idPaciente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Historial_Clinico h WHERE h.id_usuario = :idPaciente",nativeQuery = true)
    public int eliminarPorPaciente(@Param("idPaciente") Long  idPaciente);

}