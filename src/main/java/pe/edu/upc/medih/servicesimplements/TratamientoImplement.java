package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Tratamiento;
import pe.edu.upc.medih.repositories.ITratamientoRepository;
import pe.edu.upc.medih.servicesinterfaces.ITratamientoService;

import java.util.List;

@Service
public class TratamientoImplement implements ITratamientoService {

    @Autowired
    private ITratamientoRepository tratamientoRepository;

    @Override
    public List<Tratamiento> list() {
        return tratamientoRepository.findAll();
    }

    @Override
    public void insert(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public Tratamiento searchById(int id) {
        return tratamientoRepository.findById(id).orElse(new Tratamiento());
    }

    @Override
    public Tratamiento searchbyId(int id) {
        return null;
    }

    @Override
    public void update(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public void delete(int id) {
        tratamientoRepository.deleteById(id);
    }
}

