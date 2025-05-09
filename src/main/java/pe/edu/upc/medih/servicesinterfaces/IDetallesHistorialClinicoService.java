package pe.edu.upc.medih.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.medih.entities.DetallesHistorialClinico;

import java.util.List;

public interface IDetallesHistorialClinicoService {
    List<DetallesHistorialClinico> list();
    void insert(DetallesHistorialClinico detallesHistorialClinico);
    DetallesHistorialClinico searchById(int id);
    void update(DetallesHistorialClinico detallesHistorialClinico);
    void delete(int id);

    public List<String[]> HistorialClinicoPorUsuario(long id);
}