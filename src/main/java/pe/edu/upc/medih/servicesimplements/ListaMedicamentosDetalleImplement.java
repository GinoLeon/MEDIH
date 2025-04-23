package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.ListaMedicamentosDetalle;
import pe.edu.upc.medih.repositories.IListaMedicamentosDetalleRepository;
import pe.edu.upc.medih.servicesinterfaces.IListaMedicamentosDetalleService;

import java.util.List;

@Service
public class ListaMedicamentosDetalleImplement implements IListaMedicamentosDetalleService {
    @Autowired
    private IListaMedicamentosDetalleRepository lmR;
    @Override
    public List<ListaMedicamentosDetalle> list() {
        return lmR.findAll();
    }

    @Override
    public void insert(ListaMedicamentosDetalle listaMedicamentosDetalle) {
        lmR.save(listaMedicamentosDetalle);
    }

    @Override
    public ListaMedicamentosDetalle searchbyid(int id) {
        return lmR.findById(id).orElse(new ListaMedicamentosDetalle());
    }

    @Override
    public void update(ListaMedicamentosDetalle listaMedicamentosDetalle) {
        lmR.save(listaMedicamentosDetalle);
    }

    @Override
    public void delete(int id) {
        lmR.deleteById(id);
    }
}
