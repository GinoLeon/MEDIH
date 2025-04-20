package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Especialidad;

import java.util.List;

public interface IEspecialidadService {
    public List<Especialidad> list();
    public void insert(Especialidad especialidad);

    public Especialidad searchbyId(int id);
    public void update(Especialidad a);

    public void delete(int id);
}
