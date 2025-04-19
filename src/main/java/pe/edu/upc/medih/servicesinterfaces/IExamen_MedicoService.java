package pe.edu.upc.medih.servicesinterfaces;
import pe.edu.upc.medih.entities.Examen_Medico;

import java.util.List;

public interface IExamen_MedicoService {
    public List<Examen_Medico> list();
    public void insert(Examen_Medico especialidad);

    public Examen_Medico searchbyId(int id);
    public void update(Examen_Medico a);

    public void delete(int id);
}
