package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> list();
    public void insert(Rol rol);

    public Rol searchbyId(int id);
    public void update(Rol a);

    public void delete(int id);
}
