package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Especialidad;

import java.util.List;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {
    @Query(value = "SELECT e.nombre_especialidad, COUNT(ue.id_usuario_especialidad) AS cantidad_doctores\n" +
            " FROM usuario_especialidad ue\n" +
            " INNER JOIN especialidad e ON ue.id_especialidad = e.id_especialidad\n" +
            " GROUP BY e.nombre_especialidad\n",nativeQuery = true)
    public List<String[]> CantidadDoctoresEspecialidad();
}
