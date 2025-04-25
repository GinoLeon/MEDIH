package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Cita_Medica;

import java.util.List;

public interface ICita_MedicaService {
    List<Cita_Medica> list();

    void insert(Cita_Medica cita);

    Cita_Medica searchById(int id);

    void update(Cita_Medica cita);

    void delete(int id);
}
