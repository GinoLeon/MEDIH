package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.Receta_MedicaDTO;
import pe.edu.upc.medih.dtos.queries.CantidadRolDTO;
import pe.edu.upc.medih.dtos.queries.DoctorRecetasDTO;
import pe.edu.upc.medih.entities.Receta_Medica;
import pe.edu.upc.medih.servicesinterfaces.IReceta_MedicaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/RecetaMedica")
public class Receta_MedicaController {

    @Autowired
    private IReceta_MedicaService rM;

    @GetMapping
    public List<Receta_MedicaDTO> listar() {
        return rM.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, Receta_MedicaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody Receta_MedicaDTO dto) {
        ModelMapper m = new ModelMapper();
        Receta_Medica receta = m.map(dto, Receta_Medica.class);
        rM.insert(receta);
    }

    @GetMapping("/{id}")
    public Receta_MedicaDTO buscarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Receta_MedicaDTO dto = m.map(rM.searchById(id), Receta_MedicaDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody Receta_MedicaDTO dto) {
        ModelMapper m = new ModelMapper();
        Receta_Medica receta = m.map(dto, Receta_Medica.class);
        rM.update(receta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rM.delete(id);
    }

    // This method is used to count the number of prescriptions by doctor
    @GetMapping("/contarPorDoctor")
    public List<Object[]> contarPorDoctor() {
        return rM.countRecetasByDoctor();
    }


    @GetMapping("/medicamentos-recetados")
    public List<DoctorRecetasDTO> obtenerMedicamentosRecetados(@RequestParam LocalDate fecha) {
        List<DoctorRecetasDTO> dtolista = new ArrayList<>();
        List<String[]> fila= rM.obtenerMedicamentosRecetados(fecha);
        for (String[]columna : fila) {
            DoctorRecetasDTO dto = new DoctorRecetasDTO();
            dto.setName(columna[0]);
            dto.setDoctorId(Integer.parseInt(columna[1]));
            dtolista.add(dto);
        }
        return dtolista;
    }


    @GetMapping("/recetas-por-paciente")
    public List<Object[]> obtenerRecetasPorPaciente() {
        return rM.obtenerRecetasPorPaciente();
    }
}
