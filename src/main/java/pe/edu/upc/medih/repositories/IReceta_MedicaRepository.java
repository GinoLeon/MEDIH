package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Receta_Medica;

import java.util.List;

@Repository
public interface IReceta_MedicaRepository extends JpaRepository<Receta_Medica, Integer> {

    // Custom query to find Receta_Medica by estado
    @Query("SELECT r.doctor.nombreUsuario, COUNT(r) FROM Receta_Medica r GROUP BY r.doctor")
    List<Object[]> countRecetasByDoctor();


    @Query("SELECT u.nombreUsuario AS nombreDoctor, COUNT(r.idReceta) AS totalRecetas " +
            "FROM Receta_Medica r " +
            "JOIN r.doctor u " +
            "WHERE r.fecha > :fecha " +
            "GROUP BY u.nombreUsuario " +
            "ORDER BY totalRecetas DESC")
    List<Object[]> obtenerMedicamentosRecetados(@Param("fecha") String fecha);
}