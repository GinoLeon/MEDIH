package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Diagnostico;
import pe.edu.upc.medih.repositories.IDDiagnosticoRepository;
import pe.edu.upc.medih.servicesinterfaces.IDiagnosticoService;

import java.util.List;

@Service
public class DiagnosticoServiceImpl implements IDiagnosticoService {

    @Autowired
    private IDDiagnosticoRepository diagnosticoRepository;

    @Override
    public void insert(Diagnostico diagnostico) {
        diagnosticoRepository.save(diagnostico);
    }

    @Override
    public List<Diagnostico> list() {
        return diagnosticoRepository.findAll();
    }

    @Override
    public void delete(int id) {
        diagnosticoRepository.deleteById(id);
    }

    @Override
    public Diagnostico findById(int id) {
        return diagnosticoRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Diagnostico diagnostico) {
        diagnosticoRepository.save(diagnostico);
    }

    @Override
    public void deleteByEstado(String estado) {
        diagnosticoRepository.deleteByEstado(estado);
    }
}