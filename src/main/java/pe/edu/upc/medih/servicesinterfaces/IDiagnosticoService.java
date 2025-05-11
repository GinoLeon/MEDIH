package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Diagnostico;

import java.time.LocalDate;
import java.util.List;

public interface IDiagnosticoService {
    public void insert(Diagnostico diagnostico);
    public List<Diagnostico> list();
    public void delete(int id);
    public Diagnostico findById(int id);
    public void update(Diagnostico diagnostico);

    public List<Diagnostico> findByDescripcionContaining(String descripcion);
    public List<String[]> findRecentDiagnosticos(LocalDate fecha);
}