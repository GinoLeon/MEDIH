package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Receta_Medica;
import pe.edu.upc.medih.repositories.IReceta_MedicaRepository;
import pe.edu.upc.medih.servicesinterfaces.IReceta_MedicaService;

import java.time.LocalDate;
import java.util.List;

@Service
public class Receta_MedicaImplement implements IReceta_MedicaService {

    @Autowired
    private IReceta_MedicaRepository recetaMedicaRepository;

    @Override
    public void insert(Receta_Medica recetaMedica) {
        recetaMedicaRepository.save(recetaMedica);
    }

    @Override
    public List<Receta_Medica> list() {
        return recetaMedicaRepository.findAll();
    }

    @Override
    public Receta_Medica searchById(int id) {
        return recetaMedicaRepository.findById(id).orElse(new Receta_Medica());
    }

    @Override
    public void update(Receta_Medica recetaMedica) {
        recetaMedicaRepository.save(recetaMedica);
    }

    @Override
    public void delete(int id) {
        recetaMedicaRepository.deleteById(id);
    }

    // This method is used to count the number of prescriptions by doctor
    @Override
    public List<Object[]> countRecetasByDoctor() {
        return recetaMedicaRepository.countRecetasByDoctor();
    }

    @Override
    public List<String[]> obtenerMedicamentosRecetados(LocalDate fecha) {
        return recetaMedicaRepository.obtenerMedicamentosRecetados(fecha);
    }

    @Override
    public List<Object[]> obtenerRecetasPorPaciente() {
        return recetaMedicaRepository.contarRecetasPorPaciente();
    }
}
