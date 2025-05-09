package pe.edu.upc.medih.servicesimplements;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Rol;
import pe.edu.upc.medih.repositories.IRolRepository;
import pe.edu.upc.medih.servicesinterfaces.IRolService;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository rolesServices;

    @Override
    public List<Rol> list() {
        return rolesServices.findAll();
    }

    @Override
    public void insert(Rol rol) {
        rolesServices.save(rol);
    }

    @Override
    public Rol searchbyId(Long id) {
        return rolesServices.findById(id).orElse(new Rol());
    }

    @Override
    public void update(Rol a) {
        rolesServices.save(a);
    }

    @Override
    public void deleteRolById(Long id) {
        rolesServices.deleteRolById(id);
    }
}
