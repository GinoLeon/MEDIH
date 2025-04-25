package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.medih.entities.Cita_Medica;

public interface ICita_MedicaRepository extends JpaRepository<Cita_Medica, Integer> {
}