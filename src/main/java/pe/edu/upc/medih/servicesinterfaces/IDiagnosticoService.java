package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Diagnostico;

import java.util.List;

public interface IDiagnosticoService {
    void insert(Diagnostico diagnostico);
    List<Diagnostico> list();
    void delete(int id);
    Diagnostico findById(int id);
    void update(Diagnostico diagnostico);
    void deleteByEstado(String estado);
    List<Diagnostico> findByDescripcionContaining(String descripcion);
    List<Diagnostico> findRecentDiagnosticos(String fecha);
}