package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Receta_Medica;

import java.util.List;

@Repository
public interface IReceta_MedicaRepository extends JpaRepository<Receta_Medica, Integer> {

    @Query(value = "SELECT u.nombres AS nombreDoctor, COUNT(r.id_receta) AS totalRecetas " +
            "FROM RecetasMedicas r " +
            "JOIN Usuario u ON r.id_doctor = u.id_usuario " +
            "WHERE r.fecha > '2025-01-01' " +
            "GROUP BY u.nombres " +
            "ORDER BY totalRecetas DESC", nativeQuery = true)
    List<String[]> cantidadRecetasPorDoctorDesde2025();
}