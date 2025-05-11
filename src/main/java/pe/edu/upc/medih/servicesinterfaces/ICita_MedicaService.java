package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Cita_Medica;

import java.util.List;

public interface ICita_MedicaService {

    public List<Cita_Medica> list();
    public List<Cita_Medica> findByEstado(String estado);
    public void insert(Cita_Medica cita);
    public Cita_Medica searchById(int id);
    public void update(Cita_Medica cita);
    public void delete(int id);
}
