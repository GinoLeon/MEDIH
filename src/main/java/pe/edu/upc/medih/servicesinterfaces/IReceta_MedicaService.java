package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Receta_Medica;
import java.util.List;

public interface IReceta_MedicaService {
    List<Object[]> countRecetasByDoctor();
    void insert(Receta_Medica recetaMedica);
    List<Receta_Medica> list();
    Receta_Medica searchById(int id);
    void update(Receta_Medica recetaMedica);
    void delete(int id);


    List<Object[]> obtenerMedicamentosRecetados(String fecha);
}