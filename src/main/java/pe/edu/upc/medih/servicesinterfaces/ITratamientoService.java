package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Tratamiento;

import java.util.List;

public interface ITratamientoService {
    List<Tratamiento> list();

    void insert(Tratamiento tratamiento);

    Tratamiento searchById(int id);

    Tratamiento searchbyId(int id);

    void update(Tratamiento tratamiento);

    void delete(int id);
}
