package pe.edu.upc.medih.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.medih.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> list();
    public void insert(Rol rol);

    public Rol searchbyId(Long id);
    public void update(Rol a);

    public void deleteRolById(Long id);
}
