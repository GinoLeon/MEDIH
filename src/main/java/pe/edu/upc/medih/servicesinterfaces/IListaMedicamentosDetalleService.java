package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.ListaMedicamentosDetalle;

import java.util.List;

public interface IListaMedicamentosDetalleService {
    public List<ListaMedicamentosDetalle> list();
    public void insert(ListaMedicamentosDetalle listaMedicamentosDetalle);

    public ListaMedicamentosDetalle searchbyid(int id);
    public void update(ListaMedicamentosDetalle listaMedicamentosDetalle);
    public void delete(int id);
}
