package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Receta_Medica;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IReceta_MedicaRepository extends JpaRepository<Receta_Medica, Integer> {


    @Query(value = "SELECT r.id_doctor ,COUNT(*) as RecetasHechas FROM recetas_medicas r\n" +
            "GROUP BY r.id_doctor",nativeQuery = true)
    public List<String[]> countRecetasByDoctor();


    @Query(value = "SELECT u.nombre_usuario AS nombreDoctor, COUNT(r.id_receta) AS totalRecetas \n" +
            "            FROM Recetas_Medicas r \n" +
            "            JOIN usuarios u ON r.id_doctor = u.id \n" +
            "            WHERE r.fecha > :fecha \n" +
            "            GROUP BY u.nombre_usuario \n" +
            "            ORDER BY totalRecetas DESC",nativeQuery = true)
    public List<String[]> obtenerMedicamentosRecetados(@Param("fecha") LocalDate fecha);


    @Query(value = "SELECT u.nombre_usuario AS paciente, COUNT(r.id_usuario) AS totalRecetas FROM recetas_medicas r \n" +
            "jOIN usuarios u on r.id_usuario=u.id\n" +
            "GROUP BY u.nombre_usuario\n" +
            "ORDER BY totalRecetas DESC",nativeQuery = true)
    public List<String[]> contarRecetasPorPaciente();
}