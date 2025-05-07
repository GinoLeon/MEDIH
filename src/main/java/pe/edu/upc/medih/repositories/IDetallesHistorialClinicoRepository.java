package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.medih.entities.DetallesHistorialClinico;

public interface IDetallesHistorialClinicoRepository extends JpaRepository<DetallesHistorialClinico, Integer> {
}