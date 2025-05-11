package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Receta_Medica;

import java.time.LocalDate;
import java.util.List;

public interface IReceta_MedicaService {
    public List<Object[]> countRecetasByDoctor();
    public void insert(Receta_Medica recetaMedica);
    public List<Receta_Medica> list();
    public Receta_Medica searchById(int id);
    public void update(Receta_Medica recetaMedica);
    public void delete(int id);

    public List<String[]> obtenerMedicamentosRecetados(LocalDate fecha);
    public List<Object[]> obtenerRecetasPorPaciente();
}