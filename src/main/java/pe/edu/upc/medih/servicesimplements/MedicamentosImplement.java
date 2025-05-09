package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Medicamento;
import pe.edu.upc.medih.repositories.IMedicamentosRepository;
import pe.edu.upc.medih.servicesinterfaces.IMedicamentoService;

import java.util.List;

@Service
public class MedicamentosImplement implements IMedicamentoService {

    @Autowired
    private IMedicamentosRepository Mr;
    @Override
    public List<Medicamento> list() {
        return Mr.findAll();
    }

    @Override
    public void insert(Medicamento medicamento) {
        Mr.save(medicamento);
    }

    @Override
    public Medicamento searchbyid(int id) {
        return Mr.findById(id).orElse(new Medicamento());
    }

    @Override
    public void update(Medicamento medicamento) {
        Mr.save(medicamento);
    }

    @Override
    public void delete(int id) {
        Mr.deleteById(id);
    }

    @Override
    public List<String[]> medicamentosMasRecetados() {
        return Mr.medicamentosMasRecetados();
    }
}
