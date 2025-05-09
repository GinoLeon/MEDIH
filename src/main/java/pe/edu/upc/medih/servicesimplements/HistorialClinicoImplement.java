package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.HistorialClinico;
import pe.edu.upc.medih.repositories.IHistorialClinicoRepository;
import pe.edu.upc.medih.servicesinterfaces.IHistorialClinicoService;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialClinicoImplement implements IHistorialClinicoService {

    @Autowired
    private IHistorialClinicoRepository hcR;

    @Override
    public void insert(HistorialClinico historial) {
        hcR.save(historial);
    }

    @Override
    public List<HistorialClinico> list() {
        return hcR.findAll();
    }

    @Override
    public HistorialClinico searchById(int id) {
        Optional<HistorialClinico> optional = hcR.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void delete(int id) {
        hcR.deleteById(id);
    }

    @Override
    public void update(HistorialClinico historial) {
        hcR.save(historial);
    }
    @Override
    public List<HistorialClinico> listByUsuarioId(int usuarioId) {
        return hcR.findByPacienteId(usuarioId);
    }

    @Override
    public void eliminarPorPaciente(Long idPaciente) {
        hcR.eliminarPorPaciente(idPaciente);
    }
}
