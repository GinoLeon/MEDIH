package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.DetallesHistorialClinico;

import java.util.List;

public interface IDetallesHistorialClinicoService {
    List<DetallesHistorialClinico> list();
    void insert(DetallesHistorialClinico detallesHistorialClinico);
    DetallesHistorialClinico searchById(int id);
    void update(DetallesHistorialClinico detallesHistorialClinico);
    void delete(int id);
}