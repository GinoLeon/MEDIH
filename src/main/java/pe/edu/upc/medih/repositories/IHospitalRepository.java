package pe.edu.upc.medih.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Hospital;

import java.util.List;


@Repository
public interface IHospitalRepository extends JpaRepository<Hospital, Integer> {
    @Query(value = "SELECT \n" +
            "    h.nombre_Hospital,\n" +
            "    ROUND(\n" +
            "        6371 * ACOS(\n" +
            "            COS(RADIANS(:latitudUsuario)) * \n" +
            "            COS(RADIANS(h.latitud)) * \n" +
            "            COS(RADIANS(h.longitud) - RADIANS(:longitudUsuario)) +\n" +
            "            SIN(RADIANS(:latitudUsuario)) * \n" +
            "            SIN(RADIANS(h.latitud))\n" +
            "        )::numeric, 2\n" +
            "    ) AS distancia_km\n" +
            "FROM Hospital h\n" +
            "ORDER BY distancia_km\n" +
            "LIMIT 5 ",nativeQuery = true)
    public List<String[]> getDistanciaKm(@Param("latitudUsuario") double latitud, @Param("longitudUsuario") double longitud);
}
