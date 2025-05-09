package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Medicamento;

import java.util.List;

@Repository
public interface IMedicamentosRepository extends JpaRepository<Medicamento, Integer> {

    @Query(value = "SELECT m.nombre_medicamento, COUNT(DISTINCT r.id_receta) AS total_recetas " +
            "FROM Medicamentos m " +
            "JOIN ListaMedicamentos_Detalle lmd ON m.id_medicamento = lmd.id_medicamento " +
            "JOIN RecetasMedicas r ON lmd.id_lista = r.id_lista_medicamento_detalle " +
            "GROUP BY m.nombre_medicamento " +
            "HAVING COUNT(DISTINCT r.id_receta) > 5 " +
            "ORDER BY total_recetas DESC", nativeQuery = true)
    List<String[]> medicamentosMasRecetados();
}
