package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.HistorialClinico;

import java.util.List;

public interface IHistorialClinicoService {
    public void insert(HistorialClinico historial);
    public List<HistorialClinico> list();
    public HistorialClinico searchById(int id);
    public void delete(int id);
    public void update(HistorialClinico historial);
    public List<HistorialClinico> listByUsuarioId(int usuarioId); // query
}
