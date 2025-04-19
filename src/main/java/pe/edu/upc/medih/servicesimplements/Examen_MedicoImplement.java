package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Examen_Medico;
import pe.edu.upc.medih.repositories.IExamen_MedicoRepository;
import pe.edu.upc.medih.servicesinterfaces.IExamen_MedicoService;

import java.util.List;
@Service
public class Examen_MedicoImplement implements IExamen_MedicoService {
    @Autowired
    private IExamen_MedicoRepository eR;

    @Override
    public List<Examen_Medico> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Examen_Medico especialidad) {
        eR.save(especialidad);
    }

    @Override
    public Examen_Medico searchbyId(int id) {
        return eR.findById(id).orElse(new Examen_Medico());
    }

    @Override
    public void update(Examen_Medico a) {
        eR.save(a);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }
}
