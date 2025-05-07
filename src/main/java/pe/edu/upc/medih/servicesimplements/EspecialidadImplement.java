package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Especialidad;
import pe.edu.upc.medih.repositories.IEspecialidadRepository;
import pe.edu.upc.medih.servicesinterfaces.IEspecialidadService;

import java.util.List;

@Service
public class EspecialidadImplement implements IEspecialidadService {
    @Autowired
    private IEspecialidadRepository eR;

    @Override
    public List<Especialidad> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Especialidad especialidad) {
        eR.save(especialidad);
    }

    @Override
    public Especialidad searchbyId(int id) {
        return eR.findById(id).orElse(new Especialidad());
    }

    @Override
    public void update(Especialidad a) {
        eR.save(a);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }

    @Override
    public List<String[]> CantidadDoctoresEspecialidad() {
        return eR.CantidadDoctoresEspecialidad();
    }
}
