package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.DetallesHistorialClinico;
import pe.edu.upc.medih.repositories.IDetallesHistorialClinicoRepository;
import pe.edu.upc.medih.servicesinterfaces.IDetallesHistorialClinicoService;

import java.util.List;

@Service
public class DetallesHistorialClinicoImplement implements IDetallesHistorialClinicoService {
    @Autowired
    private IDetallesHistorialClinicoRepository dR;

    @Override
    public List<DetallesHistorialClinico> list() {
        return dR.findAll();
    }

    @Override
    public void insert(DetallesHistorialClinico detallesHistorialClinico) {
        dR.save(detallesHistorialClinico);
    }

    @Override
    public DetallesHistorialClinico searchById(int id) {
        return dR.findById(id).orElse(new DetallesHistorialClinico());
    }

    @Override
    public void update(DetallesHistorialClinico detallesHistorialClinico) {
        dR.save(detallesHistorialClinico);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }
}