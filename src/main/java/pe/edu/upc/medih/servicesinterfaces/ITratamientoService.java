package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Tratamiento;

import java.util.List;

public interface ITratamientoService {
    public List<Tratamiento> list();

    public void insert(Tratamiento tratamiento);

    public Tratamiento searchById(int id);
    public void update(Tratamiento tratamiento);

    public void delete(int id);
}
