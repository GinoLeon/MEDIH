package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.medih.entities.DetallesHistorialClinico;

import java.util.List;

public interface IDetallesHistorialClinicoRepository extends JpaRepository<DetallesHistorialClinico, Integer> {
    @Query(value = "SELECT \n" +
            "    d.id_detalle_historial,\n" +
            "    h.fecha_registro,\n" +
            "    u.nombre_usuario,\n" +
            "    t.tipo_tratamiento,\n" +
            "    t.fecha_inicio,\n" +
            "    t.fecha_fin,\n" +
            "    e.tipo_examen,\n" +
            "    e.resultado_examen,\n" +
            "    e.fecha_examen,\n" +
            "    m.nombre_medicamento,\n" +
            "    diag.descripcion\n" +
            "FROM \n" +
            "    detalles_historial_clinico d\n" +
            "JOIN \n" +
            "    historial_clinico h ON d.id_historial = h.id_historial\n" +
            "JOIN \n" +
            "    usuarios u ON h.id_usuario = u.id\n" +
            "JOIN \n" +
            "    tratamiento t ON d.id_tratamiento = t.id_tratamiento\n" +
            "JOIN \n" +
            "    examen_medico e ON d.id_examen = e.id_examen\n" +
            "JOIN \n" +
            "    lista_medicamentos_detalle md ON d.id_lista_medicamento = md.id_medicamento_detalle\n" +
            "JOIN \n" +
            "    medicamento m ON md.id_medicamento = m.id_medicamento\n" +
            "JOIN \n" +
            "    diagnostico diag ON d.id_diagnostico = diag.id_diagnostico\n" +
            "WHERE \n" +
            "    u.id = :id; ",nativeQuery = true)
    public List<String[]> HistorialClinicoPorUsuario(@Param("id") long id);

}