package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Medicamento;

import java.util.List;

public interface IMedicamentoService {
    public List<Medicamento> list();
    public void insert(Medicamento medicamento);

    public Medicamento searchbyid(int id);
    public void update(Medicamento medicamento);

    public void delete(int id);

}
