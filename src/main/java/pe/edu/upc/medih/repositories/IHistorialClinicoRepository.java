package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.medih.entities.HistorialClinico;

public interface IHistorialClinicoRepository extends JpaRepository<HistorialClinico, Integer> {
}
