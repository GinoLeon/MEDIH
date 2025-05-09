package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Cita_Medica;
import pe.edu.upc.medih.repositories.ICita_MedicaRepository;
import pe.edu.upc.medih.servicesinterfaces.ICita_MedicaService;

import java.util.List;

@Service
public class Cita_MedicaImplement implements ICita_MedicaService {

    @Autowired
    private ICita_MedicaRepository cR;

    @Override
    public List<Cita_Medica> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Cita_Medica cita) {
        cR.save(cita);
    }

    @Override
    public Cita_Medica searchById(int id) {
        return cR.findById(id).orElse(new Cita_Medica());
    }

    @Override
    public void update(Cita_Medica cita) {
        cR.save(cita);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public List<Cita_Medica> findByEstado(String estado) {
        return cR.findByEstado(estado);}
}